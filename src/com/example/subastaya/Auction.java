package com.example.subastaya;

import retrofit.Callback;

public interface Auction {

	public void nextProduct(Callback<AuctionResponse> callback);
	public void prevProduct(Callback<AuctionResponse> callback);
	
}
