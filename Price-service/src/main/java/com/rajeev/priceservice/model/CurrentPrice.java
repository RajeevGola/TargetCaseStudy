package com.rajeev.priceservice.model;

public class CurrentPrice {
	float  value;
	String currency_code;
	public CurrentPrice(){
		
	}
	public CurrentPrice(float value, String currency_code) {
		super();
		this.value = value;
		this.currency_code = currency_code;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

}
