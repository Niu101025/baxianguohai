package com.niu.yumao.service;

import com.niu.yumao.domain.Admin;
import com.niu.yumao.domain.Leave;

import java.util.List;

public interface LeaveService {


	void save(Leave leave);


	List<Leave> loadAllLeave();

	void deleteLeaveById(Integer lid);
}
