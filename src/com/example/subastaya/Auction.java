package com.example.subastaya;

public interface Auction {

	public Product nextProduct() throws NoItemsFoundException;
	public Product prevProduct() throws NoItemsFoundException;
	public Product currentProduct() throws NoItemsFoundException;
	
}
