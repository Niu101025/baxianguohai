package com.niu.yumao.action;

import com.niu.yumao.domain.Category;
import com.niu.yumao.domain.Info;
import com.niu.yumao.domain.Product;
import com.niu.yumao.domain.ProductBean;
import com.niu.yumao.service.CategoryService;
import com.niu.yumao.service.InfoService;
import com.niu.yumao.service.ProductService;
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

    private Integer categoryid = -1;

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

    public String findAll() {
        try {
            List<Product> hotProduct = productService.findAllHotProduct();
            ActionContext.getContext().getValueStack().set("hotProduct", hotProduct);
            getAndSaveInfo();
            return "findAllSuccess";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "查询热门商品时发生错误"+e.getMessage());
            return "findAllError";
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
            ActionContext.getContext().getValueStack().set("errorinfo", "获取网站详情时发生错误！"+e.getMessage());
            return "getInfoError";
        }

    }

    public String goLeave() {
        try {
            getAndSaveInfo();
            return "getLeaveSuccess";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "获取网站详情时发生错误！"+e.getMessage());
            return "getLeaveError";
        }

    }

    public String getAllCate() {
        try {
            getAllProduct();
            getAndSaveInfo();
            getAllCategory();

            return "getAllCateSuccess";
        } catch (Exception e) {
            ActionContext.getContext().getValueStack().set("errorinfo", "获取全部分类时发生错误！"+e.getMessage());
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
            ActionContext.getContext().getValueStack().set("errorinfo", "获取全部分类时发生错误！"+e.getMessage());
            return "getAllCate1Error";
        }
    }

    private void getAllCategory() {
        List<Category> allCategory = categoryService.findAllCategory();
        ActionContext.getContext().getValueStack().set("allCategory", allCategory);
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
