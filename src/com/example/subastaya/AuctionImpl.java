package com.example.subastaya;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.example.subastaya.apimodels.ProductSearch;
import com.example.subastaya.apimodels.Result;

public class AuctionImpl implements Auction {
	
	private static final Integer MAX_PRODS_PER_CALL = 50;
	
	List<Product> products = new ArrayList<Product>();
	Integer page = 0; // Page of the search you are currently in
	Integer index = 0; // Means the product you are currently looking at
	Integer total = -1;
	
	boolean isApiCallPending = false;
	
	MercadoLibreAPI mercadoLibreService;
	MeliOAuth meliOAuthService;
	String query;
		
	AuctionImpl(final String query) {
		this.query = query;
		
		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.mercadolibre.com").build();
		this.mercadoLibreService = restAdapter.create(MercadoLibreAPI.class);
		
		RestAdapter restAdapterOAuth = new RestAdapter.Builder().setEndpoint("http://auth.mercadolibre.com").build();
		this.meliOAuthService = restAdapterOAuth.create(MeliOAuth.class);	
	}
	
	public void fetch(final Callback<AuctionResponse> callback) {
		if ( ! this.isApiCallPending ) {
			this.isApiCallPending = true;
			this.mercadoLibreService.searchByQuery(this.query, MAX_PRODS_PER_CALL, page * MAX_PRODS_PER_CALL, "OAuth " + MainActivity.APP_TOKEN,
					new Callback<ProductSearch> () {
				
						@Override
						public void failure(RetrofitError arg0) {
							isApiCallPending = false;
							callback.success(new AuctionResponse(AuctionState.API_ERROR, null, false, false), null);							
						}

						@Override
						public void success(ProductSearch productSearch, Response arg1) {
							isApiCallPending = false;
							products.clear();
							AuctionState state;
							
							for (Result result : productSearch.getResults()) {
								products.add( new ProductImpl(result.getTitle(), result.getPrice()) );
							}	

							if ( products.isEmpty() ) {
								state = AuctionState.EMPTY_RESULTS; 
							} else {
								state = AuctionState.OK;
							}
							
							total = productSearch.getPaging().getTotal();
							
							callback.success(new AuctionResponse(state, null, false, false), null);							
						}
				
			}); 
		}
	}
	
	public boolean hasProductsLeft() {
		return total > MAX_PRODS_PER_CALL * page + index + 1; 
	}
	
	public boolean isInLimitOfThePage() {
		return index == MAX_PRODS_PER_CALL - 1;
	}

	@Override
	public void nextProduct(final Callback<AuctionResponse> callback) {
		if ( ! this.isApiCallPending ) {
			if ( total == -1 ) {
				this.fetch(new Callback<AuctionResponse>() {

					@Override
					public void failure(RetrofitError arg0) {
					}

					@Override
					public void success(AuctionResponse auctionResponse, Response arg1) {
						if ( auctionResponse.getState() == AuctionState.API_ERROR ) {
							callback.success(auctionResponse, null);
							return;
						}
						
						index = 0;
						page = 0;
						if ( auctionResponse.getState() == AuctionState.OK ) {
							auctionResponse.setProduct(products.get(index));
							auctionResponse.setHasPrevious(false);
							auctionResponse.setHasNext(hasProductsLeft());
						}
						callback.success(auctionResponse, null);
					}
					
				});
				return;
			}
			
			if ( hasProductsLeft() && isInLimitOfThePage() ) {
				page++;
				this.fetch(new Callback<AuctionResponse>() {

					@Override
					public void failure(RetrofitError arg0) {
					}

					@Override
					public void success(AuctionResponse auctionResponse, Response arg1) {
						if ( auctionResponse.getState() == AuctionState.API_ERROR ) {
							callback.success(auctionResponse, null);
							return;
						}
						
						index = 0;
						auctionResponse.setHasPrevious(true);
						auctionResponse.setHasNext(hasProductsLeft());
						auctionResponse.setProduct(products.get(index));
						callback.success(auctionResponse, null);
					}	
				});
				return;
			}
			
			index++;
			AuctionResponse auctionResponse = new AuctionResponse(
					AuctionState.OK, this.products.get(index), 
					true, hasProductsLeft());
			callback.success(auctionResponse, null);			
		}
	}

	@Override
	public void prevProduct(final Callback<AuctionResponse> callback) {
		if ( ! this.isApiCallPending ) {
			if ( total == -1 || (index == 0 && page == 0)) {
				return;
			}
			
			if ( page != 0 && index == 0 ) {
				page--;
				this.fetch(new Callback<AuctionResponse>() {

					@Override
					public void failure(RetrofitError arg0) {
					}

					@Override
					public void success(AuctionResponse auctionResponse, Response arg1) {
						if ( auctionResponse.getState() == AuctionState.API_ERROR ) {
							callback.success(auctionResponse, null);
							return;
						}						
						index = MAX_PRODS_PER_CALL - 1;
						auctionResponse.setHasPrevious(!(index == 0 && page == 0));
						auctionResponse.setHasNext(true);
						auctionResponse.setProduct(products.get(index));
						callback.success(auctionResponse, null);
					}	
				});
				return;
			}
			
			index--;
			AuctionResponse auctionResponse = new AuctionResponse(
					AuctionState.OK, this.products.get(index), 
					!(index == 0 && page == 0), true);
			
			callback.success(auctionResponse, null);			
		}
	}
	
}
