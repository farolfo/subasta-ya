package com.example.subastaya;

public class ProductImpl implements Product {

	String name;
	
	ProductImpl(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean offer(double price) {
		// TODO Auto-generated method stub
		return false;
	}

}
