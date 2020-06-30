package com.example.dao;

import com.example.HibernateSessionFactory;
import com.example.dao.daoApi.LoginDao;
import com.example.entity.AbstractEntity;
import com.example.entity.LoginData;
import com.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class LoginDaoImpl implements LoginDao {

    private final Logger logger = LoggerFactory.getLogger(LoginDaoImpl.class);

    public LoginData findByLogin(String login) {
        logger.info("find login data by login {}", login);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            LoginData loginData =
                    session.createQuery
                            ("SELECT l FROM LoginData l where l.Login=:login", LoginData.class)
                            .setParameter("login", login)
                            .getSingleResult();
            return loginData;
        } catch (Exception e) {
            logger.debug("Exception find login data by login - {} - {}", login, e);
        }
        return null;

    }


    @Override
    public LoginData findById(int id) {
        logger.info("find login data by id {}", id);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(LoginData.class, id);
        } catch (Exception e) {
            logger.debug("error find login by id {} - {}", id, e);
        }
        return null;
    }

    @Override
    public List<LoginData> findAll() {
        logger.info("find all login data");
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("SELECT l FROM LoginData l ", LoginData.class).getResultList();
        } catch (Exception e) {
            logger.debug("error find all login data - {}", e.toString());
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        logger.info("unusable statement - delete login by id");
    }

    @Override
    public void update(AbstractEntity entity) {
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
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
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}
