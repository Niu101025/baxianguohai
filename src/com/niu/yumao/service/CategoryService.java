package com.niu.yumao.service;

import java.util.List;

import com.niu.yumao.domain.Category;

public interface CategoryService {

	void addCategory(Category category);

	List<Category> findAllCategory();

	Category findById(Integer cid);

	void saveCategory(Category category);

	void deleteCategory(Category category);

	
	
}
