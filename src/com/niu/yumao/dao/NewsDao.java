package com.niu.yumao.dao;

import com.niu.yumao.domain.News;

import java.util.List;

public interface NewsDao {

	void add(News news);


	List<News> findByPage(Integer start, Integer end);

	int findCount();

	News findById(Integer pid);

	void delete(News news);

	void save(News news);

	List<News> findAllHotNews();

	List<News> findAllNews();

	List<News> findAllNewsByTypeid(int cid);

	News findNewsById(Integer pid);
}
