package com.product.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	@GetMapping("/getProductsInfo")
	public String getProductsInfo() {
		return "index";
	}

	@PostMapping("/addProducts")
	public String addProducts() {
		return "index";
	}

}
