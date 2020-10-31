package com.user.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthorizationServer {

	public static void main(String[] args) {
		
		System.setProperty("spring.config.name", "user-authorization-server");
		SpringApplication.run(AuthorizationServer.class, args);
	}

}
