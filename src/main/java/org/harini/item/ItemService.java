package org.harini.item;

import org.harini.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ItemService {
    public static List<Item> getAllItems() {
        Transaction transaction = null;
        List<Item> items = null;

        try {
            Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Item.class);
            SessionFactory sf = con.buildSessionFactory();
            Session session = sf.openSession();
            transaction = session.beginTransaction();

            // HQL Query
            items = session.createQuery("FROM Item", Item.class).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return items;
    }
}
