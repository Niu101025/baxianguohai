package com.niu.yumao.domain;

import java.util.List;

/**
 * Created by niuhongbin on 17/1/1.
 */
public class ProductBean {
    private List<Product> productList;
    private Integer nextpid;
    private Integer prepid;
    private Integer cid;
    private Boolean home;
    private Boolean isfirst;
    private Boolean islast;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer getNextpid() {
        return nextpid;
    }

    public void setNextpid(Integer nextpid) {
        this.nextpid = nextpid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPrepid() {
        return prepid;
    }

    public void setPrepid(Integer prepid) {
        this.prepid = prepid;
    }

    public Boolean getHome() {
        return home;
    }

    public void setHome(Boolean home) {
        this.home = home;
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
