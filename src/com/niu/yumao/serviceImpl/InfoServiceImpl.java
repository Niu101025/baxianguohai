package com.niu.yumao.serviceImpl;

import com.niu.yumao.dao.InfoDao;
import com.niu.yumao.domain.Info;
import com.niu.yumao.service.InfoService;

public class InfoServiceImpl implements InfoService  {
	private InfoDao infoDao;

	public void setInfoDao(InfoDao infoDao) {
		this.infoDao = infoDao;
	}

	@Override
	public Info findInfo() {
		// TODO Auto-generated method stub
		return infoDao.findInfo();
	}

	@Override
	public void updateInfo(Info info) {
		// TODO Auto-generated method stub
		infoDao.updateInfo(info);
	}
	
}
