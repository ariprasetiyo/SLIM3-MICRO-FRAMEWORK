/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.service;

import ari.test.model.ModelEntity;
import ari.test.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ari-prasetiyo
 */
public class DoSaveService<T extends ModelEntity> {

    protected Class<T> clazz;

    public void doSave(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (Exception x) {
            x.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public boolean doSaveTest(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Object test = session.save(t);
            transaction.commit();
            if (test != null) {
                return true;
            }
        } catch (Exception x) {
            x.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }
}
