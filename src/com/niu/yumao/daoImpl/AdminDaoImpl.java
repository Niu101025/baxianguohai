package com.niu.yumao.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.niu.yumao.dao.AdminDao;
import com.niu.yumao.domain.Admin;

public class AdminDaoImpl extends HibernateDaoSupport  implements AdminDao{
	public AdminDaoImpl(SessionFactory sessionfactory){
	    setSessionFactory(sessionfactory);
	}

	@Override
	public List<Admin> findAdminByAdmin(final Admin admin) {
		Object execute =  super.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Admin.class);
				if(admin != null)
					criteria.add(Example.create(admin));
				return criteria.list();
			}
		});
		return (List<Admin>)execute;
	}
	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(admin);
	}
}
