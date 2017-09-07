package com.niu.yumao.action;

import com.niu.yumao.domain.Category;
import com.niu.yumao.domain.NewsType;
import com.niu.yumao.domain.PageBean;
import com.niu.yumao.domain.News;
import com.niu.yumao.service.CategoryService;
import com.niu.yumao.service.InfoService;
import com.niu.yumao.service.NewsService;
import com.niu.yumao.service.NewsTypeService;
import com.niu.yumao.utils.ImageUtils;
import com.niu.yumao.utils.OperateImage;
import com.niu.yumao.utils.StrUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import java.awt.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAction extends ActionSupport implements ModelDriven<News> {

    private News news = new News();

    @Override
    public News getModel() {
        // TODO Auto-generated method stub
        return news;
    }

    private NewsService newsService;

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    private NewsTypeService newsTypeService;

    public void setNewsTypeService(NewsTypeService newsTypeService) {
        this.newsTypeService = newsTypeService;
    }

    private InfoService infoService;

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    /**
     * 添加产品
     *
     * @return
     */
    public String add() {

        news.setNewsTime(new Date());
        newsService.add(news);
        return "saveNewsSuccess";
    }


    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public String findAllNews() {
        PageBean<News> pageBean = newsService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAllNewsSuccess";
    }

    public String findAll() {
        PageBean<News> pageBean = newsService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAllSuccess";
    }

    public String edit() {
        List<NewsType> newsTypes = newsTypeService.findAllNewsType();
        PageBean<NewsType> pageBean = new PageBean<NewsType>();
        pageBean.setList(newsTypes);
        ActionContext.getContext().getValueStack().push(pageBean);
        News mNews = newsService.findById(news.getNewsId());
        ActionContext.getContext().getValueStack().push(mNews);
        return "editNewsSuccess";
    }


    public String save() {
        newsService.save(news);
        return "saveSuccess";
    }

    public String delete() {
        newsService.deleteNews(news);
        return "deleteSuccess";
    }
}
