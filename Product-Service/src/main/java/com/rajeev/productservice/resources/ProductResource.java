package com.rajeev.productservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.rajeev.productservice.model.CacheServer;
import com.rajeev.productservice.model.ProductSpecification;



@RestController
@RequestMapping("/products")
public class ProductResource {
	  @Autowired
	    private RestTemplate restTemplate;
	  @Autowired
	    private CacheServer cacheServer;

    @RequestMapping("/{productsId}")
    public ProductSpecification getProductName(@PathVariable("productsId") String productsId) {
    
    	ProductSpecification ps= cacheServer.getProductSpecification(productsId);
    	
    	if(null==ps){
         	
	    	String url = "https://redsky.target.com/v2/pdp/tcin/" + productsId + "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
	    	System.out.println(url);
	    	String response= "not found";
	    	try{
	    		response = restTemplate.getForObject(url, String.class);
	    		System.out.println("response :"+response );
	    		ps = new ProductSpecification(productsId,productsId+"_Name");
	    		
	    	}catch (HttpClientErrorException e){
	    		//product not found;
	    	}
    	}
    //	System.out.println(response); 
        return ps;
    }

    

}
