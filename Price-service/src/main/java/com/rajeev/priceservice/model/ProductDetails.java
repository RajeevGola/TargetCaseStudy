package com.rajeev.priceservice.model;

public class ProductDetails {
	String id;
	String name;
	CurrentPrice current_price;
	public ProductDetails(String id, String name, CurrentPrice current_price) {
		super();
		this.id = id;
		this.name = name;
		this.current_price = current_price;
	}
	public ProductDetails() {

	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CurrentPrice getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(CurrentPrice current_price) {
		this.current_price = current_price;
	}

}
