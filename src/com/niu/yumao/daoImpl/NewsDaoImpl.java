package com.niu.yumao.daoImpl;

import com.niu.yumao.dao.NewsDao;
import com.niu.yumao.dao.NewsDao;
import com.niu.yumao.domain.News;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class NewsDaoImpl extends HibernateDaoSupport implements NewsDao {
    public NewsDaoImpl(SessionFactory sessionfactory) {
        setSessionFactory(sessionfactory);
    }

    @Override
    public void add(News news) {
        // TODO Auto-generated method stub
        this.getHibernateTemplate().save(news);
    }

    @Override
    public List<News> findByPage(Integer start, Integer end) {
        DetachedCriteria dc = DetachedCriteria.forClass(News.class);
        List<News> newss = this.getHibernateTemplate().findByCriteria(dc, start, end);
        return newss;
    }

    @Override
    public int findCount() {
        String hql = "select count(*) from News as news";
        Long count = (Long) getHibernateTemplate().find(hql).listIterator().next();
        return count.intValue();
    }

    @Override
    public News findById(Integer pid) {
        DetachedCriteria dc = DetachedCriteria.forClass(News.class);
        dc.add(Restrictions.eq("newsId", pid));
        List<News> newss = this.getHibernateTemplate().findByCriteria(dc);
        if (newss != null && newss.size() > 0) {
            return newss.get(0);
        }

        return null;
    }

    @Override
    public void delete(News news) {
        this.getHibernateTemplate().delete(news);
    }

    @Override
    public void save(News news) {
        this.getHibernateTemplate().update(news);
    }

    @Override
    public List<News> findAllHotNews() {
        DetachedCriteria dc = DetachedCriteria.forClass(News.class);
        dc.add(Restrictions.eq("ishome", true));
        List<News> newss = this.getHibernateTemplate().findByCriteria(dc);
        return newss;
    }

    @Override
    public List<News> findAllNews() {
        DetachedCriteria dc = DetachedCriteria.forClass(News.class);
        List<News> newss = this.getHibernateTemplate().findByCriteria(dc);
        return newss;
    }

    @Override
    public List<News> findAllNewsByTypeid(int typeid) {
        DetachedCriteria dc = DetachedCriteria.forClass(News.class);
        dc.add(Restrictions.eq("newsType.newsTypeId", typeid));
        List<News> newss = this.getHibernateTemplate().findByCriteria(dc);
        return newss;
    }

    @Override
    public News findNewsById(Integer newsId) {
        DetachedCriteria dc = DetachedCriteria.forClass(News.class);
        dc.add(Restrictions.eq("newsId", newsId));
        List<News> newss = this.getHibernateTemplate().findByCriteria(dc);
        if (newss != null && newss.size() > 0) {
            return newss.get(0);
        }
        return null;
    }

}
