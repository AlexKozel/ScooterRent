package com.example.dao;

import com.example.HibernateSessionFactory;
import com.example.dao.daoApi.UserDao;
import com.example.entity.AbstractEntity;
import com.example.entity.RentStory;
import com.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    private final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);


    public User findByUserName(String name) {
        logger.info("Finding user by userName {}", name);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return (User) session.createQuery("Select User from User where User.firstName =" + name).getSingleResult();
        } catch (Exception e) {
            logger.debug("Exception from DAO -" + e);
        }
        return null;
    }

    @Override
    public User findById(int id) {
        logger.info("Finding user by id {}", id);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        } catch (Exception e) {
            logger.debug("Exception from DAO - {}", e.toString());
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        logger.info("Find all users");
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("SELECT u FROM User u", User.class).getResultList();
        }
    }

    @Override
    public void deleteById(int id) {
        logger.info("delete user by id");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            User user = session.load(User.class, id);
            session.delete(user);
            for (RentStory story : user.getRentStoryList()) {
                story.setUser(null);
            }
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            logger.debug("ERROR deleting user with id {}{}", id, e.toString());
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void update(AbstractEntity entity) {
        logger.info("update user {}", entity);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error update user {} - {}", entity, e);
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void save(AbstractEntity entity) {
        logger.info("save user {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error save user {} - {}", entity, e);
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}
