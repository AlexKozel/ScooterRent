package com.example.dao;

import com.example.HibernateSessionFactory;
import com.example.dao.daoApi.DiscountDao;
import com.example.entity.AbstractEntity;
import com.example.entity.Discount;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountDaoImpl implements DiscountDao {

    private final Logger logger = LoggerFactory.getLogger(DiscountDaoImpl.class);

    @Override
    public Discount findById(int id) {
        logger.info("find discount by id {}", id);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Discount.class, id);
        } catch (Exception e) {
            logger.debug("error find discount by id {} - {}", id, e);
        }
        return null;
    }

    @Override
    public List<Discount> findAll() {
        logger.info("find all discounts");
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("SELECT d FROM Discount d ", Discount.class).getResultList();
        } catch (Exception e) {
            logger.debug("error find all discounts {}", e.toString());
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        logger.info("find discount by id {}", id);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Discount discount = session.load(Discount.class, id);
            session.delete(discount);
            discount.getUser().setDiscount(null);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error find discount by id {} - {}", id, e);
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
        logger.info("update dicount {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error update discount {} = {}", entity, e);
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
        logger.info("save discount {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error save discount {} - {}", entity, e);
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}
