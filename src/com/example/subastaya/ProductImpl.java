package com.example.subastaya;

public class ProductImpl implements Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String title;
	Double price;
	
	ProductImpl(String title, Double price) {
		this.title = title;
		this.price = price;
	}
	
	@Override
	public String getTitle() {
		return this.title;
	}
	
	@Override
	public Double getPrice() {
		return price;
	}
	
	@Override
	public boolean offer(double price) {
		// TODO Auto-generated method stub
		return false;
	}

}
