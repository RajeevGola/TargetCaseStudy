package com.rajeev.priceservice.resources;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.rajeev.priceservice.model.CacheServer;
import com.rajeev.priceservice.model.CurrentPrice;
import com.rajeev.priceservice.model.ProductDetails;


@RestController
@RequestMapping("/product")
public class PriceResource {
	  @Autowired
	    private CacheServer cacheServer;
	 @Autowired
	  Environment environment;


	
    @RequestMapping("/{productsId}/price")
    //TODO handle wrong product code
    public CurrentPrice getProductPrice(@PathVariable("productsId") String productsId) {
    	  String port = environment.getProperty("local.server.port");
    	System.out.println("PriceService Port:"+ port);
        return cacheServer.getProductPrice(productsId);
    }
    
    @RequestMapping(method=RequestMethod.POST,value= "/{productsId}/price")
    public void addPrice( @RequestBody ProductDetails product ){
    	System.out.println("Got Price to be  updated for product "+product.getId()+" Price :"+product.getCurrent_price().getValue());
    	cacheServer.updateProductPrice(product.getId(), product.getCurrent_price());
    	
    }
   


}
