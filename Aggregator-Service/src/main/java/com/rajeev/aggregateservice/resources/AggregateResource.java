package com.rajeev.aggregateservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.rajeev.aggregateservice.model.CurrentPrice;
import com.rajeev.aggregateservice.model.ProductDetails;
import com.rajeev.aggregateservice.model.ProductSpecification;



@RestController
@RequestMapping("/product")
public class AggregateResource {
	 @Autowired
	    private RestTemplate restTemplate;
	
    @RequestMapping("/{productsId}/price")
    //TODO handle wrong product code
    public ProductDetails getProductPrice(@PathVariable("productsId") String productsId) {
    	CurrentPrice productPrice=new CurrentPrice(-1,"USD");
    	ProductSpecification productSpecification;
    	//Get product name
    	String productNameServiceURL = "http://PRODUCT-SERVICE/products/"+productsId;
    	System.out.println(productNameServiceURL); 
    	productSpecification = restTemplate.getForObject(productNameServiceURL, ProductSpecification.class);
    	//http://localhost:8082/product/15117729/price
    //	String productPriceURL= "http://localhost:8082/product/15117729/price";
//Get Price;
    	String productPriceURL= "http://PRICE-SERVICE/product/"+productsId+"/price";
    	productPrice = restTemplate.getForObject(productPriceURL, CurrentPrice.class);
    	System.out.println("Price "+productPrice.getValue());
    	productPrice= 	new CurrentPrice(productPrice.getValue(),"USD");
    	ProductDetails productinfo = new ProductDetails(productsId,productSpecification.getName(),productPrice);
    	return productinfo;
      
    }
    @RequestMapping(method=RequestMethod.POST,value= "/{productsId}/price")
    public void addProducct( @RequestBody ProductDetails product ){
    	String productPriceURL= "http://PRICE-SERVICE/product/"+product.getId()+"/price"; 	
    	ProductDetails pr= restTemplate.postForObject(productPriceURL, product, ProductDetails.class);
    	
    }
   
}
