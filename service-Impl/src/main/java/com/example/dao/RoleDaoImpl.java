package com.example.dao;

import com.example.HibernateSessionFactory;
import com.example.dao.daoApi.DiscountDao;
import com.example.dao.daoApi.RoleDao;
import com.example.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleDaoImpl implements RoleDao {

    private final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);

    @Override
    public Role findById(int id) {
        logger.info("find role by id {}", id);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Role.class, id);
        } catch (Exception e) {
            logger.debug("error find role by id {} - {}", id, e);
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        logger.info("find all roles");
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("SELECT r FROM Role r ", Role.class).getResultList();
        } catch (Exception e) {
            logger.debug("error find all roles - {}", e.toString());
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        logger.info("delete role by id {}", id);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Role role = session.load(Role.class, id);
            System.out.println(role.getLoginDates());
            session.delete(role);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error delete role by id {} - {}", id, e);
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
        logger.info("Update role {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error update role {} - {}", entity, e);
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
        logger.info("save role {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error save role {} - {}", entity, e);
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}
