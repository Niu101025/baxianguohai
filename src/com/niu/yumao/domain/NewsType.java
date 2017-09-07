package com.niu.yumao.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 存储新闻的类型
 */
public class NewsType {
    //新闻类型ID
    private Integer newsTypeId;
    //新闻类型名字
    private String newsTypeName;
    //新闻类型是否首页展示
    private Boolean showHome;
    //新闻显示的权重，权重越大，越优先显示
    private Integer showWeight;
    //新闻类型对应的新闻
    private Set<News> newsList = new HashSet<News>();


    public Integer getNewsTypeId() {
        return newsTypeId;
    }

    public void setNewsTypeId(Integer newsTypeId) {
        this.newsTypeId = newsTypeId;
    }

    public String getNewsTypeName() {
        return newsTypeName;
    }

    public void setNewsTypeName(String newsTypeName) {
        this.newsTypeName = newsTypeName;
    }

    public Boolean getShowHome() {
        return showHome;
    }

    public void setShowHome(Boolean showHome) {
        this.showHome = showHome;
    }

    public Integer getShowWeight() {
        return showWeight;
    }

    public void setShowWeight(Integer showWeight) {
        this.showWeight = showWeight;
    }

    public Set<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(Set<News> newsList) {
        this.newsList = newsList;
    }
}
