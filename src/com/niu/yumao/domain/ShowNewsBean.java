package com.niu.yumao.domain;

import java.util.List;

/**
 * Created by niuhongbin on 17/9/10.
 */
public class ShowNewsBean {
    private NewsType newsType;
    private List<News> newsList;

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
