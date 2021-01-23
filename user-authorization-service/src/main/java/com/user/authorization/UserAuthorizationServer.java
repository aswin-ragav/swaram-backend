package com.user.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@EnableCaching
public class UserAuthorizationServer {

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "user-authorization-service");
		SpringApplication.run(UserAuthorizationServer.class, args);
	}
}
