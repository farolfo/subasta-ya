package com.example.subastaya;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

import com.example.subastaya.apimodels.ProductSearch;

public interface MercadoLibreAPI {
	@Headers("Authorization: OAuth uk3qZb6iSmSEd75paPiYVCYsD8mHbFPD")
		
	@GET("/sites/MLA/search?buying_mode=auction")
	void searchByQuery(@Query("q") String query, @Query("limit") Integer limit, @Query("offset") Integer offset, Callback<ProductSearch> callback);
}
