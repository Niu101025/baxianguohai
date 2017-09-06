package com.niu.yumao.serviceImpl;

import com.niu.yumao.dao.AdminDao;
import com.niu.yumao.dao.LeaveDao;
import com.niu.yumao.domain.Admin;
import com.niu.yumao.domain.Leave;
import com.niu.yumao.service.AdminService;
import com.niu.yumao.service.LeaveService;

import java.util.List;

public class LeaveServiceImpl implements LeaveService {
    private LeaveDao leaveDao;


    public void setLeaveDao(LeaveDao leaveDao) {
        this.leaveDao = leaveDao;
    }

    @Override
    public void save(Leave leave) {
        leaveDao.save(leave);
    }

    @Override
    public List<Leave> loadAllLeave() {
        return leaveDao.loadAllLeave();
    }

    @Override
    public void deleteLeaveById(Integer lid) {
        leaveDao.deleteLeaveById(lid);
    }
}
