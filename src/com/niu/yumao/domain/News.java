package com.niu.yumao.domain;

import java.util.Date;

/**
 * 存储新闻
 */
public class News {
    //新闻id
    private Integer newsId;
    //新闻标题
    private String newsTitle;
    //新闻副标题
    private String newsTitle2;
    //新聞類型
    private String newsContent;
    //新闻添加时间
    private Date newsTime;
    //新闻类型
    private NewsType newsType;
    //点击量
    private Integer newsClickNum;

    private Boolean ishome;

    public Boolean getIshome() {
        return ishome;
    }

    public void setIshome(Boolean ishome) {
        this.ishome = ishome;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsTitle2() {
        return newsTitle2;
    }

    public void setNewsTitle2(String newsTitle2) {
        this.newsTitle2 = newsTitle2;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    public Integer getNewsClickNum() {
        return newsClickNum;
    }

    public void setNewsClickNum(Integer newsClickNum) {
        this.newsClickNum = newsClickNum;
    }
}
