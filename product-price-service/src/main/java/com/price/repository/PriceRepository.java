package com.price.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.price.model.ProductPrice;

@Repository
public interface PriceRepository extends CrudRepository<ProductPrice, Long>, JpaRepository<ProductPrice, Long> {

//	@Query("SELECT p FROM Price p where p.product_Id=:productId")
	public ProductPrice findByProductId(@Param("productId") long productid);
}
