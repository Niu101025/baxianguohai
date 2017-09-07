package com.niu.yumao.service;

import com.niu.yumao.domain.PageBean;
import com.niu.yumao.domain.News;

import java.util.List;

public interface NewsService {

	void add(News news);


	PageBean<News> findByPage(Integer currentPage);

	News findById(Integer pid);

	void deleteNews(News news);

	void save(News news);

	List<News> findAllHotNews();

	List<News> findAllNews();

	List<News> findAllNewsByTypeId(int cid);

	News findNewsById(Integer pid);
}
