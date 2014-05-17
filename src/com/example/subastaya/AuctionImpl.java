package com.example.subastaya;

import java.util.ArrayList;
import java.util.List;

public class AuctionImpl implements Auction {
	
	List<Product> products = new ArrayList<Product>();
	Integer page = -1; // Page of the search you are currently in
	Integer index = -1; // Means the product you are currently looking at
	
	AuctionImpl(String query) {
		this.products.add( new ProductImpl("Producto 1") );
		this.products.add( new ProductImpl("Producto 2") );
		this.products.add( new ProductImpl("Producto 3") );
		this.products.add( new ProductImpl("Producto 4") );
		this.products.add( new ProductImpl("Producto 5") );
		this.products.add( new ProductImpl("Producto 6") );
		
		this.page = 0;
	}
	
	@Override
	public Product nextProduct() {
		if ( this.index + 1 == this.products.size() ) {
			return null;
		}
		this.index++;
		return this.products.get(this.index);
	}

	@Override
	public Product prevProduct() {
		if ( this.index <= 0 ) {
			return null;
		}
		this.index--;
		return this.products.get(this.index);
	}

	
}
