package com.example.subastaya;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

public interface MeliOAuth {
	@Headers("Authorization: OAuth uk3qZb6iSmSEd75paPiYVCYsD8mHbFPD")
	
	@GET("/authorization")
	void authorize(@Query("response_type") String responseType, @Query("client_id") String clientId, @Query("redirect_uri") String redirectUri, Callback<String> callback);
}

