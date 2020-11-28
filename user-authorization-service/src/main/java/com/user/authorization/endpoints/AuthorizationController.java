package com.user.authorization.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.authorization.entity.User;
import com.user.authorization.service.AuthororizationService;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

	@Autowired
	public AuthororizationService service;

	@PostMapping("/addUser")
	public User addUser(@RequestBody User addUser) {
		return service.addNewUser(addUser);
	}

	@PostMapping("/login")
	public void loginUser(@RequestParam String userName, @RequestParam String password) {

	}

	@PostMapping("/logout")
	public void logoutUser(@RequestParam String eMail) {

	}

	@PostMapping("/forgotPassword")
	public void forgotPassword(@RequestParam String eMail) {

	}
}
