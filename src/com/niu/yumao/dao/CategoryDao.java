package com.niu.yumao.dao;

import java.util.List;

import com.niu.yumao.domain.Category;

public interface CategoryDao {

	void addCategory(Category category);

	List<Category> findAllCategory();

	Category findById(Integer cid);

	void saveCategory(Category category);

	void deleteCategory(Category category);


}
