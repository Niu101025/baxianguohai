package com.niu.yumao.domain;

import java.util.List;

/**
 * Created by niuhongbin on 17/1/1.
 */
public class NewsBean {
    private List<News> newsList;
    private Integer nextNewId;
    private Integer preNewId;
    private Integer newsTypeId;
    private Boolean isfirst;
    private Boolean islast;

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public Integer getNextNewId() {
        return nextNewId;
    }

    public void setNextNewId(Integer nextNewId) {
        this.nextNewId = nextNewId;
    }

    public Integer getPreNewId() {
        return preNewId;
    }

    public void setPreNewId(Integer preNewId) {
        this.preNewId = preNewId;
    }

    public Integer getNewsTypeId() {
        return newsTypeId;
    }

    public void setNewsTypeId(Integer newsTypeId) {
        this.newsTypeId = newsTypeId;
    }

    public Boolean getIsfirst() {
        return isfirst;
    }

    public void setIsfirst(Boolean isfirst) {
        this.isfirst = isfirst;
    }

    public Boolean getIslast() {
        return islast;
    }

    public void setIslast(Boolean islast) {
        this.islast = islast;
    }
}
