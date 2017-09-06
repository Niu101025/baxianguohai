package com.niu.yumao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.niu.yumao.dao.InfoDao;
import com.niu.yumao.domain.Info;

public class InfoDaoImpl extends HibernateDaoSupport implements InfoDao {
	public InfoDaoImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	@Override
	public Info findInfo() {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Info.class);
		List<Info> list = this.getHibernateTemplate().findByCriteria(criteria);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public void updateInfo(Info info) {
		// TODO Auto-generated method stub
		if (findInfo() != null) {
			this.getHibernateTemplate().update(info);
		} else {
			this.getHibernateTemplate().save(info);
		}
	}
}
