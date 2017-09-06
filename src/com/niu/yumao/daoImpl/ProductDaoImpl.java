package com.niu.yumao.daoImpl;

import com.niu.yumao.dao.ProductDao;
import com.niu.yumao.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {
    public ProductDaoImpl(SessionFactory sessionfactory) {
        setSessionFactory(sessionfactory);
    }

    @Override
    public void add(Product product) {
        // TODO Auto-generated method stub
        this.getHibernateTemplate().save(product);
    }

    @Override
    public List<Product> findByPage(Integer start, Integer end) {
        DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
        List<Product> products = this.getHibernateTemplate().findByCriteria(dc, start, end);
        return products;
    }

    @Override
    public int findCount() {
        String hql = "select count(*) from Product as product";
        Long count = (Long) getHibernateTemplate().find(hql).listIterator().next();
        return count.intValue();
    }

    @Override
    public Product findById(Integer pid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
        dc.add(Restrictions.eq("pid", pid));
        List<Product> products = this.getHibernateTemplate().findByCriteria(dc);
        if (products != null && products.size() > 0) {
            return products.get(0);
        }

        return null;
    }

    @Override
    public void delete(Product product) {
        this.getHibernateTemplate().delete(product);
    }

    @Override
    public void save(Product product) {
        this.getHibernateTemplate().update(product);
    }

    @Override
    public List<Product> findAllHotProduct() {
        DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
        dc.add(Restrictions.eq("ishome", true));
        List<Product> products = this.getHibernateTemplate().findByCriteria(dc);
        return products;
    }

    @Override
    public List<Product> findAllProduct() {
        DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
        List<Product> products = this.getHibernateTemplate().findByCriteria(dc);
        return products;
    }

    @Override
    public List<Product> findAllProductByCid(int cid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
        dc.add(Restrictions.eq("category.cid", cid));
        List<Product> products = this.getHibernateTemplate().findByCriteria(dc);
        return products;
    }

    @Override
    public Product findProductById(Integer pid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
        dc.add(Restrictions.eq("pid", pid));
        List<Product> products = this.getHibernateTemplate().findByCriteria(dc);
        if (products != null && products.size() > 0) {
            return products.get(0);
        }
        return null;
    }

}
