package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, JpaRepository<Product, Long> {

	public List<Product> findByCategoryId(long categoryId);
}
