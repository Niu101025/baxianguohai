package com.niu.yumao.serviceImpl;

import java.util.List;

import com.niu.yumao.dao.CategoryDao;
import com.niu.yumao.domain.Category;
import com.niu.yumao.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.addCategory(category);
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.findAllCategory() ;
	}

	@Override
	public Category findById(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.findById(cid);
	}

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.saveCategory(category);
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.deleteCategory(category);
	}

}
