package com.user.authorization.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.authorization.entity.Authorization;
import com.user.authorization.service.AuthororizationService;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

	@Autowired
	public AuthororizationService service;

	@PostMapping("/login")
	public Authorization logIn(@RequestParam String uNameOrEmail,
	                                    @RequestParam String password) {

		return service.logIn(uNameOrEmail, password);
	}


	@PostMapping("/logout")
	public Authorization logOut(@RequestParam String uNameOrEmail) {

		return new Authorization();
	}

}
