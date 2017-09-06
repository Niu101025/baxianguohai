package com.niu.yumao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.niu.yumao.dao.CategoryDao;
import com.niu.yumao.domain.Category;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao{
	public CategoryDaoImpl(SessionFactory sessionfactory){
	    setSessionFactory(sessionfactory);
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(category);
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Category.class);
		List<Category> list = this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	@Override
	public Category findById(Integer cid) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Category.class);
		criteria.add(Restrictions.eq("cid", cid));
		List<Category> list = this.getHibernateTemplate().findByCriteria(criteria);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(category);
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(category);
	}
}
