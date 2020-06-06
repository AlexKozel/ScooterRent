package com.example;

import com.example.model.Discount;
import com.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;
    private static Session session;

    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();
                configuration.addAnnotatedClass(Discount.class);
                configuration.addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println("вот такая ошибка " + e.toString());
            }
        }
        return sessionFactory;
    }

    public static Session getSession() {
        if (session == null) {
            try {
              return getSessionFactory().openSession();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }return session;
    }
}
