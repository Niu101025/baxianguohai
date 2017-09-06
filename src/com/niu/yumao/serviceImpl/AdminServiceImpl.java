package com.niu.yumao.serviceImpl;

import java.util.List;

import com.niu.yumao.dao.AdminDao;
import com.niu.yumao.domain.Admin;
import com.niu.yumao.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public List<Admin> findAdminByAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.findAdminByAdmin(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.updateAdmin(admin);
	}
	
}
