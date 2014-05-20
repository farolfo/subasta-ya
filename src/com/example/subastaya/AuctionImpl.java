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
	
	MercadoLibreAPI mercadoLibreService;
	String query;
	AuctionState state = AuctionState.FETCHING_DATA; 
	
	//I know this is horrible to do here but I can't find a better way to communicate the rest response to the activity, code review is wellcome
	AuctionActivity auctionActivity;
	private boolean hasPagesLeft = true;
	
	AuctionImpl(final String query, final AuctionActivity auctionActivity) {
		this.auctionActivity = auctionActivity;
		this.query = query;
		
		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.mercadolibre.com").build();
		this.mercadoLibreService = restAdapter.create(MercadoLibreAPI.class);
		
		fetch();
	}
	
	public void fetch() {
		this.state = AuctionState.FETCHING_DATA; 
		mercadoLibreService.searchByQuery(query, MAX_PRODS_PER_CALL, page * MAX_PRODS_PER_CALL, new Callback<ProductSearch>() {	    
		    @Override
		    public void failure(RetrofitError retrofitError) {		    	
		    	System.out.println("error");
				state = AuctionState.API_ERROR; 
		    }

			@Override
			public void success(ProductSearch productSearch, Response arg1) {
				products.clear();
				for (Result result : productSearch.getResults()) {
					products.add( new ProductImpl(result.getTitle()) );
				}		
				state = AuctionState.SHOWING_ITEMS; 
				index = -1;
				checkIfHasLeftPages(productSearch);
				auctionActivity.onProductsUpdated();
			}
		});
	}
	
	public void checkIfHasLeftPages(ProductSearch productSearch) {
		Integer total = productSearch.getPaging().getTotal(),
				offset = productSearch.getPaging().getOffset(),
				limit = productSearch.getPaging().getLimit();

		if ( offset < total && offset >= total - limit ) {
			hasPagesLeft = false;
		} else {
			hasPagesLeft = true;
		}
	}
	
	@Override
	public Product nextProduct() throws NoItemsFoundException {
		if ( state == AuctionState.FETCHING_DATA || state == AuctionState.API_ERROR ) {
			return null;
		}
		
		if ( this.products.size() == 0 ) {
			throw new NoItemsFoundException(page);
		}
		
		this.index++;

		if ( index == this.products.size() ) {
			if ( hasPagesLeft  ) {
				this.page++;
				this.fetch();
			}
			return null;
		}
		
		return this.currentProduct();
	}

	@Override
	public Product prevProduct() throws NoItemsFoundException{
		if ( state == AuctionState.FETCHING_DATA || state == AuctionState.API_ERROR ) {
			return null;
		}
		
		if ( this.products.size() == 0 ) {
			throw new NoItemsFoundException(page);
		}
		
		this.index--;

		if ( index == -1 ) {
			if ( page != 0 ) {
				this.page--;
				this.fetch();
				return null;
			} else {
				return this.products.get(0);
			}
		}
		
		return this.currentProduct();
	}
	
	@Override
	public Product currentProduct() {
		Product ans = null;
		try{
			ans = this.products.get(this.index);
		} catch(ArrayIndexOutOfBoundsException e) {
		}
			
		return ans;
	}

	
}
