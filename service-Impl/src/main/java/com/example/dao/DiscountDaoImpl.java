package com.example.dao;

import com.example.HibernateSessionFactory;
import com.example.dao.daoApi.DiscountDao;
import com.example.model.AbstractEntity;
import com.example.model.Discount;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DiscountDaoImpl implements DiscountDao {

    public Discount findById(int id) {
        Discount d = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            d = session.get(Discount.class, id);
            System.out.println(d);
            return d;
        } catch (Exception e) {
            System.out.println("---Exception from DB - " + e);

        }return d;
    }

    @Override
    public ArrayList<Discount> findAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(AbstractEntity entity, int id) {

    }

    public void save(Discount discount){
        try(Session session = HibernateSessionFactory.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(discount);
            session.getTransaction().commit();
            session.close();
        }
    }
}
