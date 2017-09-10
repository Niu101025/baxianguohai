package com.niu.yumao.dao;

import com.niu.yumao.domain.NewsType;

import java.util.List;

public interface NewsTypeDao {

    void addNewsType(NewsType newsType);

    List<NewsType> findAllNewsType();

    NewsType findById(Integer cid);

    void saveNewsType(NewsType newsType);

    void deleteNewsType(NewsType newsType);

    List<NewsType> findAllHomeShowNewsType();

}
