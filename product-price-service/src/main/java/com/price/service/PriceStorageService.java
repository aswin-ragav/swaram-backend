package com.price.service;

import org.springframework.stereotype.Service;

import com.price.model.PriceList;
import com.price.model.ProductPrice;

@Service
public interface PriceStorageService {

	ProductPrice addProductPrice(ProductPrice add);

	PriceList addAllPrice(PriceList addPrices);

	ProductPrice getPrice(long id);

	PriceList getPrices(long productId);
}
