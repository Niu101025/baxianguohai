package com.niu.yumao.domain;

import java.util.Date;

public class Product {
	private Integer pid;
	private Boolean ishome;
	private String pname;
	private String pdesc;
	private String pimg;
	private String pcontent;
	private Date ptime;
	private Category category;
	private Integer pclicknum;
	
	
	public Integer getPclicknum() {
		return pclicknum;
	}

	public void setPclicknum(Integer pclicknum) {
		this.pclicknum = pclicknum;
	}

	public Boolean getIshome() {
		return ishome;
	}

	public void setIshome(Boolean ishome) {
		this.ishome = ishome;
	}

	public String getPimg() {
		return pimg;
	}

	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public Date getPtime() {
		return ptime;
	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
