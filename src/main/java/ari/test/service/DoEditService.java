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
public class DoEditService<T extends ModelEntity> {

    protected Class<T> clazz;

    public void doEdit(T t, String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(t);
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
}
