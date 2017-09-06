package com.niu.yumao.action;

import java.util.List;

import com.niu.yumao.domain.Admin;
import com.niu.yumao.service.AdminService;
import com.niu.yumao.utils.StrUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Admin> {


	private Admin admin = new Admin();
	

	private AdminService adminService;
	//设置AdminService的set方法，为了在spring中注入
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}

	public String login(){
		if(StrUtils.isBlank(admin.getUsername())){
		/*	this.addFieldError("name","用户名不能是空!"); */
			return "LoginFail";
			
		}else if(StrUtils.isBlank(admin.getPassword())){
			/*this.addFieldError("name","密码不能是空!"); */
			return "LoginFail";
		}else{
			List<Admin> list = adminService.findAdminByAdmin(admin);
			if(list!=null&&list.size()>0){
				return "LoginSuccess";
			}else{
				/*this.addFieldError("name","用户名密码不匹配"); */
			}
		
			return "LoginFail";
		}
	}
	
	public String modify(){
		if(StrUtils.isNotBlank(admin.getUsername())&&StrUtils.isNotBlank(admin.getPassword())){
			adminService.updateAdmin(admin);
		}else{
			return "ModifyFail";
		}
		return "ModifySuccess";
	}
}
