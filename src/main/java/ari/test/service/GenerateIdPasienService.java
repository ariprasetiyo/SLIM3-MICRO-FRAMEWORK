/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.service;

import ari.test.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

public class GenerateIdPasienService {

    public String doGenerate() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("YYMM");
            String prefix = formatDate.format(new Date());

            transaction = session.beginTransaction();
            String hql = "select sum(1) from Pasien";
            Object countResult = session.createQuery(hql).uniqueResult();

            transaction.commit();
            
            int id = (countResult == null) ? 0 : Integer.valueOf(countResult.toString());
            String leadingNumber = String.format("%06d", id);
            String generatedId = prefix + leadingNumber;
            Logger.getLogger(GenerateIdPasienService.class).info("\n---generated id : " + generatedId + "\n");
            
            return generatedId;
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
