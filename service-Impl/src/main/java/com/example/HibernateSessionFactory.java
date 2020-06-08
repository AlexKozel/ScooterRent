package com.example;

import com.example.model.*;
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
                configuration.addAnnotatedClass(City.class);
                configuration.addAnnotatedClass(LoginData.class);
                configuration.addAnnotatedClass(RentPoint.class);
                configuration.addAnnotatedClass(RentStory.class);
                configuration.addAnnotatedClass(Scooter.class);
                configuration.addAnnotatedClass(SeasonTicket.class);
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
