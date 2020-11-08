package com.product.service;

import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.model.ProductList;

@Service
public interface ProductStorageService {

	Product addProduct(Product add);

	ProductList addAllProduct(ProductList addProducts);

	Product getProduct(long id);

	ProductList getProducts(long categoryId);
}
