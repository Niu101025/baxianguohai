package com.niu.yumao.serviceImpl;

import com.niu.yumao.dao.NewsTypeDao;
import com.niu.yumao.domain.NewsType;
import com.niu.yumao.domain.NewsType;
import com.niu.yumao.service.NewsTypeService;

import java.util.List;

public class NewsTypeServiceImpl implements NewsTypeService {
    private NewsTypeDao newsTypeDao;

    public void setNewsTypeDao(NewsTypeDao newsTypeDao) {
        this.newsTypeDao = newsTypeDao;
    }

    @Override
    public void addNewsType(NewsType newsType) {
        // TODO Auto-generated method stub
        newsTypeDao.addNewsType(newsType);
    }

    @Override
    public List<NewsType> findAllNewsType() {
        // TODO Auto-generated method stub
        return newsTypeDao.findAllNewsType() ;
    }

    @Override
    public NewsType findById(Integer cid) {
        // TODO Auto-generated method stub
        return newsTypeDao.findById(cid);
    }

    @Override
    public void saveNewsType(NewsType newsType) {
        // TODO Auto-generated method stub
        newsTypeDao.saveNewsType(newsType);
    }

    @Override
    public void deleteNewsType(NewsType newsType) {
        // TODO Auto-generated method stub
        newsTypeDao.deleteNewsType(newsType);
    }
}
