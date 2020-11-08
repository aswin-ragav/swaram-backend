package com.product.service;

import org.springframework.stereotype.Service;

import com.product.model.Category;
import com.product.model.CategoryList;

@Service
public interface CategoryStorageService {

	Category addCategory(Category add);

	CategoryList addAllCategory(CategoryList addCategorys);

	Category getCategory(long id);

	CategoryList getAllCategory();
}
