package com.user.authorization.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.authorization.entity.Address;
import com.user.authorization.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	public AddressService service;

	@PostMapping("/add")
	public Address add(@RequestBody Address add) {

		return service.create(add);
	}


	@GetMapping("/{addressId}")
	public Address get(@PathVariable long addressId) {

		return service.read(addressId);
	}


	@DeleteMapping("/{addressId}")
	public boolean remove(@PathVariable long addressId) {

		return service.delete(addressId);
	}


	@PutMapping
	public Address modify(@RequestBody Address update) {

		return service.create(update);
	}
}
