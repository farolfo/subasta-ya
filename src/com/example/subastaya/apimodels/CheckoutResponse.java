package com.example.subastaya.apimodels;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class CheckoutResponse {

		@Expose
		private String external_reference;
		@Expose
		private List<Item> items = new ArrayList<Item>();
		@Expose
		private String date_created;
		@Expose
		private String id;
		@Expose
		private String collector_id;
		@Expose
		private String init_point;
		@Expose
		private Payer payer;
		@Expose
		private Back_urls back_urls;
		@Expose
		private Payment_methods payment_methods;

		public String getExternal_reference() {
		return external_reference;
		}

		public void setExternal_reference(String external_reference) {
		this.external_reference = external_reference;
		}

		public List<Item> getItems() {
		return items;
		}

		public void setItems(List<Item> items) {
		this.items = items;
		}

		public String getDate_created() {
		return date_created;
		}

		public void setDate_created(String date_created) {
		this.date_created = date_created;
		}

		public String getId() {
		return id;
		}

		public void setId(String id) {
		this.id = id;
		}

		public String getCollector_id() {
		return collector_id;
		}

		public void setCollector_id(String collector_id) {
		this.collector_id = collector_id;
		}

		public String getInit_point() {
		return init_point;
		}

		public void setInit_point(String init_point) {
		this.init_point = init_point;
		}

		public Payer getPayer() {
		return payer;
		}

		public void setPayer(Payer payer) {
		this.payer = payer;
		}

		public Back_urls getBack_urls() {
		return back_urls;
		}

		public void setBack_urls(Back_urls back_urls) {
		this.back_urls = back_urls;
		}

		public Payment_methods getPayment_methods() {
		return payment_methods;
		}

		public void setPayment_methods(Payment_methods payment_methods) {
		this.payment_methods = payment_methods;
		}

		}