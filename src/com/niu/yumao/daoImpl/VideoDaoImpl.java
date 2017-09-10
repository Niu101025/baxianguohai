package com.niu.yumao.daoImpl;

import com.niu.yumao.dao.VideoDao;
import com.niu.yumao.dao.VideoDao;
import com.niu.yumao.domain.Video;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class VideoDaoImpl extends HibernateDaoSupport implements VideoDao {
	public VideoDaoImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	@Override
	public Video findVideo() {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Video.class);
		List<Video> list = this.getHibernateTemplate().findByCriteria(criteria);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public void updateVideo(Video info) {
		// TODO Auto-generated method stub
		if (findVideo() != null) {
			this.getHibernateTemplate().update(info);
		} else {
			this.getHibernateTemplate().save(info);
		}
	}
}
