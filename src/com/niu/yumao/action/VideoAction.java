package com.niu.yumao.action;

import com.niu.yumao.domain.Info;
import com.niu.yumao.domain.Video;
import com.niu.yumao.service.InfoService;
import com.niu.yumao.service.VideoService;
import com.niu.yumao.utils.StrUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoAction extends ActionSupport implements ModelDriven<Video> {
    private Video video = new Video();

    @Override
    public Video getModel() {
        // TODO Auto-generated method stub
        return video;
    }

    private VideoService videoService;

    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }

    /**
     * 获取网站的信息
     *
     * @return
     */
    public String findVideo() {
        Video video = videoService.findVideo();
        ActionContext.getContext().getValueStack().push(video);
        return "findVideoSuccess";
    }

    /**
     * 获取网站的信息
     *
     * @return
     */
    public String findVideo1() {
        Video video = videoService.findVideo();
        ActionContext.getContext().getValueStack().push(video);
        return "findVideo1Success";
    }


    /**
     * 保存网站的信息
     *
     * @return
     */
    public String saveInfo() {
        videoService.updateVideo(video);
        return "saveVideoSuccess";
    }

}
