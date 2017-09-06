package com.niu.yumao.dao;

import com.niu.yumao.domain.Admin;
import com.niu.yumao.domain.Leave;

import java.util.List;

public interface LeaveDao {


	void save(Leave leave);

	List<Leave> loadAllLeave();

	void deleteLeaveById(Integer lid);
}
