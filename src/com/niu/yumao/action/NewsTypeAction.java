package com.niu.yumao.action;

import com.niu.yumao.domain.NewsType;
import com.niu.yumao.domain.PageBean;
import com.niu.yumao.service.NewsTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class NewsTypeAction extends ActionSupport implements ModelDriven<NewsType> {

    private NewsType newsType = new NewsType();

    @Override
    public NewsType getModel() {
        // TODO Auto-generated method stub
        return newsType;
    }

    private NewsTypeService newsTypeService;

    public void setNewsTypeService(NewsTypeService newsTypeService) {
        this.newsTypeService = newsTypeService;

    }

    public String addNewsType() {
        if (newsType != null) {
            newsTypeService.addNewsType(newsType);
            return "addNewsTypeSuccess";
        } else {
            return "addNewsTypeError";
        }
    }

    public String findAllNewsType() {
        List<NewsType> categories = newsTypeService.findAllNewsType();
        PageBean<NewsType> pageBean = new PageBean<NewsType>();
        pageBean.setList(categories);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAllNewsTypeSuccess";
    }

    public String findAll() {
        List<NewsType> categories = newsTypeService.findAllNewsType();
        PageBean<NewsType> pageBean = new PageBean<NewsType>();
        pageBean.setList(categories);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAllSuccess";
    }

    public String editNewsType() {
        NewsType mNewsType = newsTypeService.findById(newsType.getNewsTypeId());
        ActionContext.getContext().getValueStack().push(mNewsType);
        return "editNewsTypeSuccess";
    }

    public String deleteNewsType() {
        try {
            newsTypeService.deleteNewsType(newsType);
        } catch (Exception e) {
            // TODO: handle exception
            return "deleteNewsTypeFail";
        }

        return "deleteNewsTypeSuccess";
    }

    public String saveNewsType() {
        newsTypeService.saveNewsType(newsType);
        return "saveNewsTypeSuccess";
    }
}
