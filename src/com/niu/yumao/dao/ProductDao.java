package com.niu.yumao.dao;

import java.util.List;

import com.niu.yumao.domain.Category;
import com.niu.yumao.domain.PageBean;
import com.niu.yumao.domain.Product;

public interface ProductDao {

	void add(Product product);


	List<Product> findByPage(Integer start,Integer end);

	int findCount();

	Product findById(Integer pid);

	void delete(Product product);

	void save(Product product);

	List<Product> findAllHotProduct();

	List<Product> findAllProduct();

	List<Product> findAllProductByCid(int cid);

	Product findProductById(Integer pid);
}
