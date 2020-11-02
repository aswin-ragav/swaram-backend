package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductInfoService {

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "product-info-service");

		SpringApplication.run(ProductInfoService.class, args);
	}

}
