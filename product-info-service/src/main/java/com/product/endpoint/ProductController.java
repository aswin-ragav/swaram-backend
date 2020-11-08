package com.product.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.product.model.Category;
import com.product.model.Product;
import com.product.model.ProductDescription;
import com.product.model.ProductList;
import com.product.model.ProductPrice;
import com.product.service.ProductService;

@RestController
//@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	
	@GetMapping("/category/{categoryId}/product/{productId}")
	public Product getProductsInfo(@PathVariable long categoryId, @PathVariable long productId) {
		
		ProductPrice price = webClientBuilder.build()
												.get()
												.uri("http://localhost:8002/" + productId)
												.retrieve()
												.bodyToMono(ProductPrice.class)
												.block();
		
		return service.getProduct(productId);
	}

	@PostMapping("/category/{categoryId}/product")
	public Product addProducts(@PathVariable long categoryId, @RequestBody Product addProduct) {
		addProduct.setCategory(new Category(categoryId, ""));
		return service.addProduct(addProduct);
	}

	@GetMapping("/category/{categoryId}/product")
	public ProductList getProducts(@PathVariable long categoryId) {
		return service.getProducts(categoryId);
	}

	@PostMapping("/category/{categoryId}/product/addAllProduct")
	public ProductList addAllProduct(@PathVariable long categoryId, @RequestBody List<Product> addProductList) {
		ProductList addAll = new ProductList();
		addAll.setAllProducts(addProductList);

		return service.addAllProduct(addAll);
	}

}
