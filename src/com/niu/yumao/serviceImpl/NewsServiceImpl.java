package com.niu.yumao.serviceImpl;

import com.niu.yumao.dao.NewsDao;
import com.niu.yumao.domain.PageBean;
import com.niu.yumao.domain.News;
import com.niu.yumao.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao;

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	@Override
	public void add(News news) {
		// TODO Auto-generated method stub
		newsDao.add(news);
	}

	@Override
	public PageBean<News> findByPage(Integer currentPage) {
		PageBean<News> pageBean = new PageBean<News>();
		pageBean.setCurrPage(currentPage);
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		int totalCount = newsDao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin = (currentPage - 1)*pageSize;
		List<News> list = newsDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public News findById(Integer pid) {
		return newsDao.findById(pid);
	}

	@Override
	public void deleteNews(News news) {
		newsDao.delete(news);
	}

	@Override
	public void save(News news) {
		newsDao.save(news);
	}

	@Override
	public List<News> findAllHotNews() {
		return newsDao.findAllHotNews();
	}

	@Override
	public List<News> findAllNews() {
		return newsDao.findAllNews();
	}

	@Override
	public List<News> findAllNewsByTypeId(int cid) {
		return newsDao.findAllNewsByTypeid(cid);
	}

	@Override
	public News findNewsById(Integer pid) {
		return newsDao.findNewsById(pid);
	}


}
