package com.rajeev.priceservice.model;

import java.util.HashMap;
import java.util.Map;

public class CacheServer {

	private static Map<String, CurrentPrice> pricelist = new HashMap<>();
	public CacheServer(){
		pricelist.put("15117729", new CurrentPrice(15117729,"USD"));
		pricelist.put("16483589", new CurrentPrice(16483589,"GBP"));
		pricelist.put("16696652", new CurrentPrice(16752456,"INR"));
		pricelist.put("15643793", new CurrentPrice(15643793,"ERO"));
	}
	public  CurrentPrice getProductPrice(String produtid){
		
		CurrentPrice price= (CurrentPrice) pricelist.get(produtid);
		if (null==price){
			price= getfromDB(produtid);
			
		}
		return price;
	}
	private CurrentPrice getfromDB(String produtid) {
		// TODO do DB operation
		updateProductPrice( produtid,new CurrentPrice(0,"---"));
		return new CurrentPrice(0,"---");
	}
	public boolean updateProductPrice(String produtid,CurrentPrice price){
		
		//TODO check Cache size and do maintenance activity
		pricelist.put(produtid, price);
		return true;
		
	}

}
