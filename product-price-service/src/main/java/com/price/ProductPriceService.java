package com.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductPriceService {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "product-price-service");
		SpringApplication.run(ProductPriceService.class, args);
	}

}
