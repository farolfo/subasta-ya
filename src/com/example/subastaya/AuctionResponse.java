package com.example.subastaya;

public class AuctionResponse {
	
	AuctionState state;
	Product product;
	boolean hasPrevious;
	boolean hasNext;
	
	public AuctionResponse(AuctionState state, Product product,
			boolean hasPrevious, boolean hasNext) {
		this.state = state;
		this.product = product;
		this.hasPrevious = hasPrevious;
		this.hasNext = hasNext;
	}
	
	public AuctionState getState() {
		return state;
	}
	public void setState(AuctionState state) {
		this.state = state;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public boolean hasPrevious() {
		return hasPrevious;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public boolean hasNext() {
		return hasNext;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	

}
