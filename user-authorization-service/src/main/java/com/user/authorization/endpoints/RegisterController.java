package com.user.authorization.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.authorization.entity.Register;
import com.user.authorization.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	public RegisterService service;

	@PostMapping("/add")
	public Register add(@RequestBody Register add) {

		Register create = service.create(add);
		create.setPassword("");
		create.setCfnPassword("");
		return create;
	}


	// @Cacheable(key = "#registerId",
	// value = "user",
	// unless = "#result.getStatus() == 'ACTIVE'")
	@GetMapping("/{registerId}")
	public Register get(@PathVariable long registerId) {

		return service.read(registerId);
	}


	@DeleteMapping("/{registerId}")
	public boolean remove(@PathVariable long registerId) {

		return service.delete(registerId);
	}


	// @CachePut(key = "#update.id", value = "user")
	@PutMapping
	public Register modify(@RequestBody Register update) {

		Register modify = service.update(update);
		modify.setPassword("");
		return modify;
	}


	@GetMapping("username/{userName}")
	public boolean chkUserName(@PathVariable String userName) {

		return service.checkUserName(userName);
	}


	@GetMapping("/email/{email}")
	public boolean chkEmail(@PathVariable String email) {

		return service.checkEmail(email);
	}


	@GetMapping("/verify/{uid}")
	public String activateUser(@PathVariable String uid) {

		return service.activateAccount(uid);
	}
}
