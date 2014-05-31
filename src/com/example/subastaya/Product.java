package com.example.subastaya;

import java.io.Serializable;

public interface Product extends Serializable{

	public boolean offer(double price);
	public String getTitle();
	public Double getPrice();
}
