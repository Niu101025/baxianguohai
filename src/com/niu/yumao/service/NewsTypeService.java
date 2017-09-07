package com.niu.yumao.service;

import com.niu.yumao.domain.NewsType;

import java.util.List;

public interface NewsTypeService {

	void addNewsType(NewsType newsType);

	List<NewsType> findAllNewsType();

	NewsType findById(Integer newTypeId);

	void saveNewsType(NewsType newsType);

	void deleteNewsType(NewsType newsType);

	
}
