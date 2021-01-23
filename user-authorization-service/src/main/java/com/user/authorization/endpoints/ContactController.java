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

import com.user.authorization.entity.Contact;
import com.user.authorization.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	public ContactService service;

	@PostMapping("/add")
	public Contact add(@RequestBody Contact add) {

		return service.create(add);
	}


	@GetMapping("/{contactId}")
	public Contact get(@PathVariable long contactId) {

		return service.read(contactId);
	}


	@DeleteMapping("/{contactId}")
	public boolean remove(@PathVariable long contactId) {

		return service.delete(contactId);
	}


	@PutMapping
	public Contact modify(@RequestBody Contact update) {

		return service.create(update);
	}
}
