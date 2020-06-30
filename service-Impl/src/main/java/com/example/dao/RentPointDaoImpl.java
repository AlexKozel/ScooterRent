package com.example.dao;

import com.example.HibernateSessionFactory;
import com.example.dao.daoApi.RentPointDao;
import com.example.entity.AbstractEntity;
import com.example.entity.RentPoint;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentPointDaoImpl implements RentPointDao {

    private final Logger logger = LoggerFactory.getLogger(RentPointDaoImpl.class);

    @Override
    public RentPoint findById(int id) {
        logger.info("find rent point by id {}", id);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(RentPoint.class, id);
        } catch (Exception e) {
            logger.debug("error find rent point by id {} - {}", id, e);
        }
        return null;
    }

    @Override
    public List<RentPoint> findAll() {
        logger.info("find all rent points");
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("SELECT rp FROM RentPoint rp ", RentPoint.class).getResultList();
        } catch (Exception e) {
            logger.debug("error find all rent points - {}", e.toString());
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        logger.info("delete rent point by id {}", id);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            RentPoint rentPoint = session.load(RentPoint.class, id);
            session.delete(rentPoint);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error delete rent point by id {} = {}", id, e);
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
        logger.info("update rent point {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error update rent point {} - {}", entity, e);
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
        logger.info("save rent point {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error save rent point {} - {}", entity, e);
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}
