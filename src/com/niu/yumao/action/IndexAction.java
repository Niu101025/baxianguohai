package com.niu.yumao.action;

import com.niu.yumao.domain.*;
import com.niu.yumao.service.*;
import com.niu.yumao.utils.StrUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niuhongbin on 16/12/12.
 * 首页的Action,加载前台的相关信息
 */
public class IndexAction extends ActionSupport {

    private CategoryService categoryService;
    private InfoService infoService;
    private ProductService productService;

    /**
     * 注入新闻相关的service
     */

    private NewsTypeService newsTypeService;

    private VideoService videoService;
    private NewsService newsService;

    private Integer categoryid = -1;

    private Integer newsTypeId = -1;

    public void setNewsTypeId(Integer newsTypeId) {
        this.newsTypeId = newsTypeId;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }

    public void setNewsTypeService(NewsTypeService newsTypeService) {
        this.newsTypeService = newsTypeService;
    }

    public String findAll() {
        try {
            List<Product> hotProduct = productService.findAllHotProduct();
            ActionContext.getContext().getValueStack().set("hotProduct", hotProduct);
            getAndSaveInfo();
            getNewsInfo();
            return "findAllSuccess";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "查询热门商品时发生错误" + e.getMessage());
            return "findAllError";
        }

    }

    public String findVideo() {
        try {
            Video video = videoService.findVideo();
            ActionContext.getContext().getValueStack().push(video);
            getAndSaveInfo();
            return "findVideo1Success";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "查询热门商品时发生错误" + e.getMessage());
            return "findVideo1Error";
        }
    }

    /**
     * 获取新闻相关的数据
     */
    private void getNewsInfo() {
        List<ShowNewsBean> showNewsBeans = new ArrayList<ShowNewsBean>();
        List<NewsType> newsTypes = newsTypeService.findAllNewsType();
        if (newsTypes != null && newsTypes.size() > 0) {
            for (int i = 0; i < newsTypes.size(); i++) {
                ShowNewsBean showNewsBean = new ShowNewsBean();
                showNewsBean.setNewsType(newsTypes.get(i));
                showNewsBean.setNewsList(newsService.findAllNewsByTypeId(newsTypes.get(i).getNewsTypeId()));
                showNewsBeans.add(showNewsBean);
            }
        }
        if (showNewsBeans != null) {
            ActionContext.getContext().getValueStack().set("showNewsBeans", showNewsBeans);
        }
    }

    private void getAndSaveInfo() {
        Info info = infoService.findInfo();
        ActionContext.getContext().getValueStack().push(info);
    }

    public String goInfoDetail() {
        try {
            getAndSaveInfo();
            return "getInfoSuccess";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "获取网站详情时发生错误！" + e.getMessage());
            return "getInfoError";
        }

    }

    public String goLeave() {
        try {
            getAndSaveInfo();
            return "getLeaveSuccess";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "获取网站详情时发生错误！" + e.getMessage());
            return "getLeaveError";
        }

    }

    /**
     * 获取全部分类
     *
     * @return
     */
    public String getAllCate() {
        try {
            getAllProduct();
            getAndSaveInfo();
            getAllCategory();

            return "getAllCateSuccess";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "获取全部分类时发生错误！" + e.getMessage());
            return "getAllCateError";
        }
    }

    public String getAllCate1() {
        try {
            getProductByCid(categoryid);
            getAndSaveInfo();
            getAllCategory();

            return "getAllCate1Success";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "获取全部分类时发生错误！" + e.getMessage());
            return "getAllCate1Error";
        }
    }


    /**
     * 获取全部分类
     *
     * @return
     */
    public String getAllNewsType() {
        try {
            getAllNews();
            getAndSaveInfo();
            getAllNewsTypeList();

            return "getAllNewsTypeSuccess";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "获取全部新闻分类时发生错误！" + e.getMessage());
            return "getAllNewsTypeError";
        }
    }


    /**
     * 获取全部分类
     *
     * @return
     */
    public String getAllNewsType1() {
        try {
            getNewsByTid(newsTypeId);
            getAndSaveInfo();
            getAllNewsTypeList();

            return "getAllNewsTypeSuccess";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "获取全部新闻分类时发生错误！" + e.getMessage());
            return "getAllNewsTypeError";
        }
    }


    private void getAllCategory() {
        List<Category> allCategory = categoryService.findAllCategory();
        ActionContext.getContext().getValueStack().set("allCategory", allCategory);
    }


    private void getAllNewsTypeList() {
        List<NewsType> allNewsType = newsTypeService.findAllNewsType();
        ActionContext.getContext().getValueStack().set("allNewsType", allNewsType);
    }


    public void getAllProduct() {
        List<Product> allProduct = new ArrayList<Product>();
        Integer cid = -1;
        if (categoryService.findAllCategory() != null && categoryService.findAllCategory().size() > 0) {
            for (int i = 0; i < categoryService.findAllCategory().size(); i++) {
                cid = categoryService.findAllCategory().get(i).getCid();
                allProduct = productService.findAllProductByCid(cid);
                if (allProduct != null && allProduct.size() > 0) {
                    break;
                }

            }

        } else {
            allProduct = productService.findAllProduct();
            cid = -1;
        }
        ActionContext.getContext().getValueStack().set("categoryid", cid);
        ActionContext.getContext().getValueStack().set("allProduct", allProduct);
    }

    public void getNewsByTid(int tid) {
        List<News> allNews = newsService.findAllNewsByTypeId(tid);
        ActionContext.getContext().getValueStack().set("allNews", allNews);
        ActionContext.getContext().getValueStack().set("newsTypeId", tid);
    }


    public void getAllNews() {
        List<News> newsList = new ArrayList<News>();
        Integer tid = -1;
        if (newsTypeService.findAllNewsType() != null && newsTypeService.findAllNewsType().size() > 0) {
            for (int i = 0; i < newsTypeService.findAllNewsType().size(); i++) {
                tid = newsTypeService.findAllNewsType().get(i).getNewsTypeId();
                newsList = newsService.findAllNewsByTypeId(tid);
                if (newsList != null && newsList.size() > 0) {
                    break;
                }

            }

        } else {
            newsList = newsService.findAllNews();
            tid = -1;
        }
        ActionContext.getContext().getValueStack().set("newsTypeId", tid);
        ActionContext.getContext().getValueStack().set("allNews", newsList);
    }


    private Integer newsId;

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String findNews() {
        List<News> newsList = new ArrayList<News>();
        NewsBean newsBean = new NewsBean();
        if (newsTypeId != -1) {
            newsList = newsService.findAllNewsByTypeId(newsTypeId);
            newsBean.setNewsTypeId(newsTypeId);
        }
        if (newsList != null && newsList.size() > 0) {
            newsBean.setNewsList(newsList);
            for (int i = 0; i < newsList.size(); i++) {
                if (newsList.get(i).getNewsId().equals(newsId)) {
                    if (i == 0) {
                        newsBean.setIsfirst(true);
                        newsBean.setIslast(false);
                        newsBean.setPreNewId(-1);
                        if (newsList.size() > 1) {
                            newsBean.setNextNewId(newsList.get(1).getNewsId());
                        } else {
                            newsBean.setIslast(true);
                        }
                    } else if (i == newsList.size() - 1) {
                        newsBean.setIsfirst(false);
                        newsBean.setIslast(true);
                        newsBean.setPreNewId(newsList.get(i - 1).getNewsId());
                        newsBean.setNextNewId(-1);
                    } else {
                        newsBean.setIsfirst(false);
                        newsBean.setIslast(false);
                        newsBean.setPreNewId(newsList.get(i - 1).getNewsId());
                        newsBean.setNextNewId(newsList.get(i + 1).getNewsId());
                    }
                    ActionContext.getContext().getValueStack().push(newsBean);
                    break;
                }
            }
        }
        getAndSaveInfo();
        News news = newsService.findNewsById(newsId);
        ActionContext.getContext().getValueStack().push(news);
        return "getNewsSuccess";
    }


    public void getProductByCid(int cid) {
        List<Product> allProduct = productService.findAllProductByCid(cid);
        ActionContext.getContext().getValueStack().set("allProduct", allProduct);
        ActionContext.getContext().getValueStack().set("categoryid", cid);
    }


    private Integer pid;

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String findProduct() {
        List<Product> productList = new ArrayList<Product>();
        ProductBean productBean = new ProductBean();
        if (ishome) {
            productBean.setHome(true);
            productBean.setCid(-1);
            productList = productService.findAllHotProduct();
        } else if (categoryid != -1) {
            productBean.setHome(false);
            productList = productService.findAllProductByCid(categoryid);
            productBean.setCid(categoryid);
        }
        if (productList != null && productList.size() > 0) {
            productBean.setProductList(productList);
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getPid().equals(pid)) {
                    if (i == 0) {
                        productBean.setIsfirst(true);
                        productBean.setIslast(false);
                        productBean.setPrepid(-1);
                        if (productList.size() > 1) {
                            productBean.setNextpid(productList.get(1).getPid());
                        } else {
                            productBean.setIslast(true);
                        }
                    } else if (i == productList.size() - 1) {
                        productBean.setIsfirst(false);
                        productBean.setIslast(true);
                        productBean.setPrepid(productList.get(i - 1).getPid());
                        productBean.setNextpid(-1);
                    } else {
                        productBean.setIsfirst(false);
                        productBean.setIslast(false);
                        productBean.setPrepid(productList.get(i - 1).getPid());
                        productBean.setNextpid(productList.get(i + 1).getPid());
                    }
                    ActionContext.getContext().getValueStack().push(productBean);
                    break;
                }
            }
        }
        getAndSaveInfo();
        Product product = productService.findProductById(pid);
        ActionContext.getContext().getValueStack().push(product);
        return "getProductSuccess";
    }


    private Boolean ishome;

    public void setIshome(Boolean ishome) {
        this.ishome = ishome;
    }
}
