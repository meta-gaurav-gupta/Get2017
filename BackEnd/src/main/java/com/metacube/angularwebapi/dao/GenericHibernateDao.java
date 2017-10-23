/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.angularwebapi.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Gaurav
 */
public abstract class GenericHibernateDao <T, ID extends Serializable> implements AbstractDao<T,ID> {
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Class<T> modelClass;

    public Class<T> getModelClass()
    {
        return modelClass;
    }

    public GenericHibernateDao(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    @Override public Iterable<T> findAll()
    {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(getModelClass());
        List<T> list = cr.list();
        return list;
    }

    @Override public T findOne(final ID primaryKey) {
        Session session = this.sessionFactory.getCurrentSession(); 
        T obj = session.get(getModelClass(),primaryKey);
        return obj;
    }


    @Override public <S extends T> S save(final S entity)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(entity);
        return entity;

    }

    @Override public boolean exists(final ID primaryKey)
    {
        return false;
    }

    @Override public T delete(ID primaryKey)
    {
        Session session = this.sessionFactory.getCurrentSession(); 
        T obj = session.get(getModelClass(),primaryKey);
        session.delete(obj);
        return obj;
    }

    @Override public Long count()
    {
        return null;
    }

    @Override
    public <S extends T> T update(S entity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(entity);
        return entity;
    }

    @Override
    public Iterable<T> findAll(Map<String, String> conditions) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(getModelClass());
        for(String key: conditions.keySet()) {
            try {
                int value = Integer.parseInt(conditions.get(key));
                cr.add(Restrictions.eq(key, value));
            } catch (NumberFormatException ex) {
                cr.add(Restrictions.eq(key, conditions.get(key)));
            }
        }
        List<T> list = cr.list();
        return list;
        
    }

    @Override
    public Iterable<T> search(String query) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(getModelClass());
        cr.add(Restrictions.like("name", query , MatchMode.START));
        List<T> list = cr.list();
        return list;
    }
}
