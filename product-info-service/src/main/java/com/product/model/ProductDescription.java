package com.product.model;

import java.io.Serializable;

public class ProductDescription {

	private Product product;
	private Category category;
	private ProductPrice price;

	public ProductDescription() {

	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ProductPrice getPrice() {
		return price;
	}

	public void setPrice(ProductPrice price) {
		this.price = price;
	}

}
