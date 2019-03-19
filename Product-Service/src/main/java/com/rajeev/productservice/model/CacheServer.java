package com.rajeev.productservice.model;

import java.util.HashMap;
import java.util.Map;
import com.rajeev.productservice.model.ProductSpecification;
public class CacheServer {

	private static Map<String, ProductSpecification> productlist = new HashMap<>();
	public CacheServer(){
		productlist.put("15117729", new ProductSpecification("15117729","15117729_Name"));
		productlist.put("16483589", new ProductSpecification("16483589","16483589_Name"));
		productlist.put("16696652", new ProductSpecification("16752456","16752456_Name"));
		productlist.put("15643793", new ProductSpecification("15643793","15643793_Name"));
	}
	public  ProductSpecification getProductSpecification(String produtid){
		
		ProductSpecification product= (ProductSpecification) productlist.get(produtid);
		if (null==product){
			product= getfromDB(produtid);
			
		}
		return product;
	}
	private ProductSpecification getfromDB(String produtid) {
		// TODO do DB operation
		ProductSpecification productSpecification =  new ProductSpecification(produtid,"---");
		updateProductSpecification( produtid,productSpecification);
		return productSpecification;
	}
	public boolean updateProductSpecification(String produtid,ProductSpecification product){
		
		//TODO check Cache size and do maintenance activity
		productlist.put(produtid, product);
		return true;
		
	}

}
