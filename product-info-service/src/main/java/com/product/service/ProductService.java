package com.product.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Category;
import com.product.model.ProductDescription;
import com.product.model.Product;
import com.product.model.ProductList;
import com.product.model.ProductPrice;
import com.product.repository.CategoryRepository;
import com.product.repository.ProductRepository;

@Service
public class ProductService implements ProductStorageService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product add) {
		Product save = productRepository.save(add);
		if (save.getId() > 0) {
			return save;
		}

		return save;
	}

	@Override
	public ProductList addAllProduct(ProductList addProducts) {
		List<Product> saveAll = productRepository.saveAll(addProducts.getProductList());

		addProducts.setAllProducts(saveAll);
		return addProducts;
	}

	@Override
	public Product getProduct(long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public ProductList getProducts(long categoryId) {
		List<Product> findAll = productRepository.findByCategoryId(categoryId);
		ProductList list = new ProductList();
		list.setAllProducts(findAll);
 
		return list;
	}

//	@Override
//	public boolean addAllProduct(ProductList addProducts) {
//		Iterable<Product> saveAll = productRepository.saveAll(addProducts.getProductList());
//
//		return saveAll.iterator().hasNext() ? true : false;
//	}
//
//	@Override
//	public Product getProduct(long id) {
//		Optional<Product> findById = productRepository.findById(id);
//
//		return findById.isPresent() ? findById.get() : null;
//	}
//
//	@Override
//	public ProductList getProducts() {
//		Iterable<Product> findAll = productRepository.findAll();
//
//		return new ProductList().toList(findAll);
//	}

}
