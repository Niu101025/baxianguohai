package com.niu.yumao.serviceImpl;

import java.util.List;

import com.niu.yumao.dao.CategoryDao;
import com.niu.yumao.dao.ProductDao;
import com.niu.yumao.domain.Category;
import com.niu.yumao.domain.PageBean;
import com.niu.yumao.domain.Product;
import com.niu.yumao.service.CategoryService;
import com.niu.yumao.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		productDao.add(product);
	}

	@Override
	public PageBean<Product> findByPage(Integer currentPage) {
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setCurrPage(currentPage);
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		int totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin = (currentPage - 1)*pageSize;
		List<Product> list = productDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Product findById(Integer pid) {
		return productDao.findById(pid);
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.delete(product);
	}

	@Override
	public void save(Product product) {
		productDao.save(product);
	}

	@Override
	public List<Product> findAllHotProduct() {
		return productDao.findAllHotProduct();
	}

	@Override
	public List<Product> findAllProduct() {
		return productDao.findAllProduct();
	}

	@Override
	public List<Product> findAllProductByCid(int cid) {
		return productDao.findAllProductByCid(cid);
	}

	@Override
	public Product findProductById(Integer pid) {
		return productDao.findProductById(pid);
	}


}
