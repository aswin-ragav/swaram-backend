package com.product.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProductList {

	private List<Product> productList;

	public ProductList() {

	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setAllProducts(List<Product> productList) {
		this.productList = productList;
	}

	public ProductList toList(Iterable<Product> findAll) {
		ProductList productList = new ProductList();
		productList.setAllProducts(StreamSupport.stream(findAll.spliterator(), false).collect(Collectors.toList()));

		return productList;
	}

}
