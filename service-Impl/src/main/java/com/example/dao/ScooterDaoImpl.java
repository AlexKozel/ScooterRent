package com.example.dao;

import com.example.HibernateSessionFactory;
import com.example.dao.daoApi.ScooterDao;
import com.example.entity.AbstractEntity;
import com.example.entity.Scooter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScooterDaoImpl implements ScooterDao {

    private final Logger logger = LoggerFactory.getLogger(ScooterDaoImpl.class);

    @Override
    public Scooter findById(int id) {
        logger.info("find scooter by id {}", id);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Scooter.class, id);
        } catch (Exception e) {
            logger.debug("error find scooter by id {}", id);
        }
        return null;
    }

    @Override
    public List<Scooter> findAll() {
        logger.info("find all scooters");
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("SELECT s FROM Scooter s ", Scooter.class).getResultList();
        } catch (Exception e) {
            logger.debug("error find all scooters - {}", e.toString());
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        logger.info("delete scooter by id {}", id);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Scooter scooter = session.load(Scooter.class, id);
            session.delete(scooter);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error delete scooter by id {} - {}", id, e);
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
        logger.info("update scooter {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error update scooter {} - {}", entity, e);
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
        logger.info("save scooter {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error save scooter {} - {}", entity, e);
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}