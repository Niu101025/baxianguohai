package com.niu.yumao.domain;

import java.util.Date;

/**
 * 視頻中心
 */
public class Video {
    //視頻id
    private Integer vodeoId;
    //視頻标题
    private String videoTitle;
    //视频url
    private String videoUrl;
    //视频添加时间
    private Date videoTime;
    //点击量
    private Integer newsClickNum;


    public Integer getVodeoId() {
        return vodeoId;
    }

    public void setVodeoId(Integer vodeoId) {
        this.vodeoId = vodeoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Date getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Date videoTime) {
        this.videoTime = videoTime;
    }

    public Integer getNewsClickNum() {
        return newsClickNum;
    }

    public void setNewsClickNum(Integer newsClickNum) {
        this.newsClickNum = newsClickNum;
    }
}
