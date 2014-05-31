package com.example.subastaya.apimodels;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class CheckoutItems {

	@Expose
	private List<InnerCheckoutItem> items = new ArrayList<InnerCheckoutItem>();

	public List<InnerCheckoutItem> getItems() {
		return items;
	}

	public void setItems(List<InnerCheckoutItem> items) {
		this.items = items;
	}

}
