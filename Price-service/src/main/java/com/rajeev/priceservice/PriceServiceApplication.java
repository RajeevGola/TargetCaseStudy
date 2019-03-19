package com.rajeev.priceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.rajeev.priceservice.model.CacheServer;


@SpringBootApplication
@EnableEurekaClient
public class PriceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceServiceApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	public CacheServer getCacheServer() {
		return new CacheServer();
	}


}

