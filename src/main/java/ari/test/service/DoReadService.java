/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.service;

import ari.test.model.ModelEntity;
import ari.test.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author ari-prasetiyo
 */
public class DoReadService<T extends ModelEntity> {

    protected Class<T> clazz;

    public List<T> doReadList(T claazzName, Criterion... cree) {
        List<T> data = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria cre = session.createCriteria(claazzName.getClass().getName());
            for (Criterion x : cree) {
                cre.add(x);
            }
            data = cre.list();
            transaction.commit();
        } catch (Exception x) {
            x.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return data;
    }

    public List<T> doReadList(T claazzName) {
        List<T> data = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            data = session.createCriteria(claazzName.getClass().getName()).list();
            transaction.commit();
        } catch (Exception x) {
            x.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return data;
    }

    public T doReadClass(T claazzName, Criterion... cree) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria cre = session.createCriteria(claazzName.getClass().getName());
            for (Criterion x : cree) {
                cre.add(x);
            }
            transaction.commit();
            List<T> list = cre.list();
            if (list.size() != 0) {
                return list.get(0);
            }
        } catch (Exception x) {
            x.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }
}
