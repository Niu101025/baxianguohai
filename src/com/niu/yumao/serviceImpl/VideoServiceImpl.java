package com.niu.yumao.serviceImpl;

import com.niu.yumao.dao.VideoDao;
import com.niu.yumao.domain.Video;
import com.niu.yumao.service.VideoService;
import com.niu.yumao.service.VideoService;

public class VideoServiceImpl implements VideoService {
	private VideoDao infoDao;

	public void setVideoDao(VideoDao infoDao) {
		this.infoDao = infoDao;
	}

	@Override
	public Video findVideo() {
		// TODO Auto-generated method stub
		return infoDao.findVideo();
	}

	@Override
	public void updateVideo(Video info) {
		// TODO Auto-generated method stub
		infoDao.updateVideo(info);
	}
	
}
