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
	
	List<Product> products = new ArrayList<Product>();
	Integer page = -1; // Page of the search you are currently in
	Integer index = -1; // Means the product you are currently looking at
	
	AuctionImpl(String query) {
		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.mercadolibre.com").build();
		MercadoLibreAPI mercadoLibreService = restAdapter.create(MercadoLibreAPI.class);
		
		mercadoLibreService.searchByQuery(query, new Callback<ProductSearch>() {	    
		    @Override
		    public void failure(RetrofitError retrofitError) {
		    	
		    	System.out.println("error");
		    }

			@Override
			public void success(ProductSearch productSearch, Response arg1) {
				for (Result result : productSearch.getResults()) {
					products.add( new ProductImpl(result.getTitle()) );
				}				
			}
		});
	}
	
	@Override
	public Product nextProduct() {
		if ( this.index + 1 == this.products.size() ) {
			return null;
		}
		this.index++;
		return this.products.get(this.index);
	}

	@Override
	public Product prevProduct() {
		if ( this.index <= 0 ) {
			return null;
		}
		this.index--;
		return this.products.get(this.index);
	}

	
}
