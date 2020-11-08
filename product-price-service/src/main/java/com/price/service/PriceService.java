package com.price.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.model.PriceList;
import com.price.model.ProductPrice;
import com.price.repository.PriceRepository;

@Service
public class PriceService implements PriceStorageService {

	@Autowired
	private PriceRepository productRepository;

	@Override
	public ProductPrice addProductPrice(ProductPrice add) {
		ProductPrice save = productRepository.save(add);
		if (save.getPriceId() > 0) {
			return save;
		}

		return save;
	}

	@Override
	public PriceList addAllPrice(PriceList addProducts) {
		List<ProductPrice> saveAll = productRepository.saveAll(addProducts.getPriceList());

		addProducts.setPriceList(saveAll);
		return addProducts;
	}

	@Override
	public ProductPrice getPrice(long productId) {
		return productRepository.findByProductId(productId);
	}

	@Override
	public PriceList getPrices(long productId) {
//		List<ProductPrice> findAll = productRepository.findById(productId);
//		PriceList list = new PriceList();
//		list.setPriceList(findAll);

//		return list;
		return new PriceList();
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
