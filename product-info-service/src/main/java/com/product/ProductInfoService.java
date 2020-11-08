package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductInfoService {

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "product-info-service");

		SpringApplication.run(ProductInfoService.class, args);
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClient() {
		return WebClient.builder();
	}
}
