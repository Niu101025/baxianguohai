package com.niu.yumao.service;

import com.niu.yumao.domain.PageBean;
import com.niu.yumao.domain.Product;

import java.util.List;

public interface ProductService {

	void add(Product product);


	PageBean<Product> findByPage(Integer currentPage);

	Product findById(Integer pid);

	void deleteProduct(Product product);

	void save(Product product);

	List<Product> findAllHotProduct();

	List<Product> findAllProduct();

	List<Product> findAllProductByCid(int cid);

	Product findProductById(Integer pid);
}
