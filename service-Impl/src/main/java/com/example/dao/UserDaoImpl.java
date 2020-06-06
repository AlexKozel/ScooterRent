package com.example.dao;

import com.example.HibernateSessionFactory;
import com.example.dao.daoApi.UserDao;
import com.example.model.AbstractEntity;
import com.example.model.Discount;
import com.example.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDaoImpl implements UserDao {

    public String message(){
        return "Hello World!";
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            user = session.get(User.class, id);
            System.out.println(user);
            return user;
        } catch (Exception e) {
            System.out.println("---Exception from DB - " + e);

        }return user;
    }

    public ArrayList<AbstractEntity> findAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(AbstractEntity entity, int id) {

    }
}
