package com.user.authorization.endpoints;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

	@PostMapping("/addNewUser")
	public void addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String middleName,
			@RequestParam String eMail, @RequestParam String password) {

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
