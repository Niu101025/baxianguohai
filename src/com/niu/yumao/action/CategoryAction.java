package com.niu.yumao.action;

import com.niu.yumao.domain.Category;
import com.niu.yumao.domain.PageBean;
import com.niu.yumao.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class CategoryAction extends ActionSupport implements ModelDriven<Category> {

	private Category category = new Category();

	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}

	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;

	}

	public String addCategory() {
		if (category != null) {
			categoryService.addCategory(category);
			return "addCategorySuccess";
		} else {
			return "addCategoryError";
		}
	}

	public String findAllCategory() {
		List<Category> categories = categoryService.findAllCategory();
		PageBean<Category> pageBean = new PageBean<Category>();
		pageBean.setList(categories);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAllCategorySuccess";
	}
	public String findAll() {
		List<Category> categories = categoryService.findAllCategory();
		PageBean<Category> pageBean = new PageBean<Category>();
		pageBean.setList(categories);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAllSuccess";
	}

	public String editCategory() {
		Category mCategory = categoryService.findById(category.getCid());
		ActionContext.getContext().getValueStack().push(mCategory);
		return "editCategorySuccess";
	}

	public String deleteCategory() {
		try {
			categoryService.deleteCategory(category);
		} catch (Exception e) {
			// TODO: handle exception
			return "deleteCategoryFail";
		}
		
		return "deleteCategorySuccess";
	}
	public String saveCategory() {
		categoryService.saveCategory(category);
		return "saveCategorySuccess";
	}
}
