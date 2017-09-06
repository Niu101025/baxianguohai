package com.niu.yumao.domain;

/**
 * Created by niuhongbin on 16/12/14.
 */
public class Leave {
    private Integer lid;
    private String lname;
    private String ltel;
    private String lqq;
    private String lcontent;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLtel() {
        return ltel;
    }

    public void setLtel(String ltel) {
        this.ltel = ltel;
    }

    public String getLqq() {
        return lqq;
    }

    public void setLqq(String lqq) {
        this.lqq = lqq;
    }

    public String getLcontent() {
        return lcontent;
    }

    public void setLcontent(String lcontent) {
        this.lcontent = lcontent;
    }
}
