package com.niu.yumao.daoImpl;

import com.niu.yumao.dao.AdminDao;
import com.niu.yumao.dao.LeaveDao;
import com.niu.yumao.domain.Admin;
import com.niu.yumao.domain.Leave;
import com.niu.yumao.domain.Product;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class LeaveDaoImpl extends HibernateDaoSupport implements LeaveDao {
    public LeaveDaoImpl(SessionFactory sessionfactory) {
        setSessionFactory(sessionfactory);
    }


    @Override
    public void save(Leave leave) {
        this.getHibernateTemplate().save(leave);
    }

    @Override
    public List<Leave> loadAllLeave() {
        DetachedCriteria dc = DetachedCriteria.forClass(Leave.class);
        List<Leave> leaveList = this.getHibernateTemplate().findByCriteria(dc);
        return leaveList;
    }

    @Override
    public void deleteLeaveById(Integer lid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Leave.class);
        dc.add(Restrictions.eq("lid", lid));
        List<Leave> leaveList = this.getHibernateTemplate().findByCriteria(dc);
        if (leaveList != null && leaveList.size() > 0) {
            this.getHibernateTemplate().delete(leaveList.get(0));
        }

    }
}
