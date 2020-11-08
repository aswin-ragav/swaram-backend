package com.price.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price.model.ProductPrice;
import com.price.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	private PriceService service;

	@PostMapping("/")
	public ProductPrice addProducts(@RequestBody ProductPrice add) {
		return service.addProductPrice(add);
	}

	@GetMapping("/{productId}")
	public ProductPrice addPrice(@PathVariable long productId) {
		return service.getPrice(productId);
	}
}
