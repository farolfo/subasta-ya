package com.example.subastaya;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

import com.example.subastaya.apimodels.CheckoutItems;
import com.example.subastaya.apimodels.CheckoutResponse;
import com.example.subastaya.apimodels.OrderResponse;
import com.example.subastaya.apimodels.ProductSearch;
import com.example.subastaya.apimodels.TokenAuthorization;
import com.example.subastaya.apimodels.User;

public interface MercadoLibreAPI {
	
	@GET("/users/{id}")
	void getUser(@Path("id") Long id, @Header("Authorization") String token, Callback<User> callback);
	
	@POST("/oauth/token?grant_type=authorization_code&client_id=6684097356045737&client_secret=uk3qZb6iSmSEd75paPiYVCYsD8mHbFPD")
	void getToken(@Query("code") String code, @Query("redirect_uri") String redirectUri, @Header("Authorization") String token, Callback<TokenAuthorization> callback);
	
	@GET("/sites/MLA/search?buying_mode=auction")
	void searchByQuery(@Query("q") String query, @Query("limit") Integer limit, @Query("offset") Integer offset, @Header("Authorization") String token, Callback<ProductSearch> callback);

	@POST("/checkout/preferences")
	void checkout(@Body CheckoutItems items, @Query("access_token") String token, Callback<CheckoutResponse> cb);
	
	/*@GET("/items/{item_id}")
	void getItem(@Path("item_id") String itemId, Callback<ItemResponse> item);
	
	@GET("/items/{id}/description")
	void getDescription(@Path("id") String id, Callback<ItemDescriptionResponse> cb);
	
	@GET("/items/{id}/pictures")
	void getPictures(@Path("id") String id, Callback<PicturesResponse> cb);*/
	
	@POST("/orders")
	void createOrder(@Body OrderItems items, @Query("access_token") String token, Callback<OrderResponse> cb);
	
}
