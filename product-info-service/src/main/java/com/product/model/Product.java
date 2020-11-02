package com.product.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String productName;
	private String category;
	private float originalPricePer1000grams;
	private float retailPricePer1000grams;

	private String creationTime;

	public Product() {
		super();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getOriginalPricePer1000grams() {
		return originalPricePer1000grams;
	}

	public void setOriginalPricePer1000grams(float originalPricePer1000grams) {
		this.originalPricePer1000grams = originalPricePer1000grams;
	}

	public float getRetailPricePer1000grams() {
		return retailPricePer1000grams;
	}

	public void setRetailPricePer1000grams(float retailPricePer1000grams) {
		this.retailPricePer1000grams = retailPricePer1000grams;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public long getId() {
		return id;
	}
}
