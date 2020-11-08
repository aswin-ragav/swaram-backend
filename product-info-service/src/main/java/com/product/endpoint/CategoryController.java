package com.product.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Category;
import com.product.model.CategoryList;
import com.product.model.ProductDescription;
import com.product.model.ProductList;
import com.product.service.CategoryService;
import com.product.service.ProductService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@PostMapping("/")
	public Category addProducts(@RequestBody Category add) {
		return service.addCategory(add);
	}

	@GetMapping("/{id}")
	public Category getCategoryInfo(@PathVariable long id) {
		return service.getCategory(id);
	}

	@GetMapping("/getAll")
	public CategoryList getCategorys() {
		return service.getAllCategory();
	}

//	@PostMapping("/addAllProduct")
//	public boolean addAllProduct(@RequestBody List<Product> addProductList) {
//		ProductList addAll = new ProductList();
//		addAll.setAllProducts(addProductList);
//
//		return service.addAllProduct(addAll);
//	}

}
