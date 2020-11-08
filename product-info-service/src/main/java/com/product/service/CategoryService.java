package com.product.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Category;
import com.product.model.CategoryList;
import com.product.repository.CategoryRepository;

@Service
public class CategoryService implements CategoryStorageService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category add) {
		Category save = categoryRepository.save(add);

		if (save.getId() > 0) {
			return save;
		}

		return save;
	}

	@Override
	public CategoryList addAllCategory(CategoryList addAll) {
		List<Category> saveAll = categoryRepository.saveAll(addAll.getCategoryList());
		addAll.setCategoryList(saveAll);

		return addAll;
	}

	@Override
	public Category getCategory(long id) {
		Optional<Category> findById = categoryRepository.findById(id);
		return findById.get();
	}

	@Override
	public CategoryList getAllCategory() {
		List<Category> findAll = categoryRepository.findAll();
		CategoryList list = new CategoryList();
		list.setCategoryList(findAll);

		return list;
	}

}
