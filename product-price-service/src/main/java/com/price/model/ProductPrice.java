package com.price.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class ProductPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long	priceId;
	private long	productId;
	private float	originalPricePer1000g;
	private float	retailPricePer1000g;

	public ProductPrice() {
		super();
	}

	public long getPriceId() {
		return priceId;
	}

	public void setPriceId(long priceId) {
		this.priceId = priceId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public float getOriginalPricePer1000g() {
		return originalPricePer1000g;
	}

	public void setOriginalPricePer1000g(float originalPricePer1000g) {
		this.originalPricePer1000g = originalPricePer1000g;
	}

	public float getRetailPricePer1000g() {
		return retailPricePer1000g;
	}

	public void setRetailPricePer1000g(float retailPricePer1000g) {
		this.retailPricePer1000g = retailPricePer1000g;
	}

}
