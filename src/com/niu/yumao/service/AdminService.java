package com.niu.yumao.service;

import java.util.List;

import com.niu.yumao.domain.Admin;

public interface AdminService {

	/**
	 * 查询数据库中是否存在admin
	 * @param admin
	 * @return
	 */
	List<Admin> findAdminByAdmin(Admin admin);

	/**
	 * 更新admin
	 * @param admin
	 */
	void updateAdmin(Admin admin);

}
