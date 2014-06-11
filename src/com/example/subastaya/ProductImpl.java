package com.example.subastaya;

public class ProductImpl implements Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String id;
	String title;
	Double price;
	String stopTime; //In utc
	String thumbnail;
	
	ProductImpl(String id, String title, Double price, String stopTime, String thumbnail) {
		this.title = title;
		this.price = price;
		this.stopTime = stopTime;
		this.id = id;
		this.thumbnail = thumbnail;
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
	public String getId() {
		return id;
	}
	
	@Override
	public String getStopTime() {
		return stopTime;
	}
	
	@Override
	public boolean offer(double price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getThumbnail() {
		return thumbnail;
	}

}
