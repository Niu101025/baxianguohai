package com.niu.yumao.daoImpl;

import com.niu.yumao.dao.NewsTypeDao;
import com.niu.yumao.domain.NewsType;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class NewsTypeDaoImpl extends HibernateDaoSupport implements NewsTypeDao{
	public NewsTypeDaoImpl(SessionFactory sessionfactory){
	    setSessionFactory(sessionfactory);
	}

	@Override
	public void addNewsType(NewsType newsType) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(newsType);
	}

	@Override
	public List<NewsType> findAllNewsType() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(NewsType.class);
		List<NewsType> list = this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	@Override
	public NewsType findById(Integer cid) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(NewsType.class);
		criteria.add(Restrictions.eq("newsTypeId", cid));
		List<NewsType> list = this.getHibernateTemplate().findByCriteria(criteria);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void saveNewsType(NewsType newsType) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(newsType);
	}

	@Override
	public void deleteNewsType(NewsType newsType) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(newsType);
	}
}
