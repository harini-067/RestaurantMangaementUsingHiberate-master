package org.harini.labour;

import org.harini.model.Item;
import org.harini.model.Labour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LabourServices {
    public static List<Labour> getAllItems() {
        Transaction transaction = null;
        List<Labour> labour = null;

        try {
            Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Labour.class);
            SessionFactory sf = con.buildSessionFactory();
            Session session = sf.openSession();
            transaction = session.beginTransaction();

            // HQL Query
            labour = session.createQuery("FROM Labour", Labour.class).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return labour;
    }
}
