package com.niu.yumao.action;

import com.niu.yumao.domain.Admin;
import com.niu.yumao.domain.Leave;
import com.niu.yumao.service.AdminService;
import com.niu.yumao.service.LeaveService;
import com.niu.yumao.utils.StrUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class LeaveAction extends ActionSupport implements ModelDriven<Leave> {


    private Leave leave = new Leave();


    private LeaveService leaveService;

    public void setLeaveService(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    public void setLeave(Leave leave) {
        this.leave = leave;
    }

    @Override
    public Leave getModel() {
        // TODO Auto-generated method stub
        return leave;
    }


    public String saveLeave() {
        leaveService.save(leave);
        return "savaLeaveSuccess";
    }

    public String loadAllLeave() {
        List<Leave> leaveList = leaveService.loadAllLeave();
        ActionContext.getContext().getValueStack().set("leaveList",leaveList);
        return "loadAllLeaveSuccess";
    }

    public String deleteLeave(){
        leaveService.deleteLeaveById(leave.getLid());
        return "deleteLeaveSuccess";
    }
}
