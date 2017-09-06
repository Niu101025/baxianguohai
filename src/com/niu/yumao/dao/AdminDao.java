package com.niu.yumao.dao;

import java.util.List;

import com.niu.yumao.domain.Admin;

public interface AdminDao {

	List<Admin> findAdminByAdmin(Admin admin);

	void updateAdmin(Admin admin);
	
}
