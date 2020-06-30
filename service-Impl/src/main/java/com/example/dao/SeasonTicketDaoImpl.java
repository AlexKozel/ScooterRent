package com.example.dao;

import com.example.HibernateSessionFactory;
import com.example.dao.daoApi.SeasonTicketDao;
import com.example.entity.AbstractEntity;
import com.example.entity.SeasonTicket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonTicketDaoImpl implements SeasonTicketDao {

    private final Logger logger = LoggerFactory.getLogger(SeasonTicketDaoImpl.class);

    @Override
    public SeasonTicket findById(int id) {
        logger.info("find season ticket by id {}", id );
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(SeasonTicket.class, id);
        } catch (Exception e) {
            logger.debug("error find season ticket by id {}- {} ", id, e);
        }
        return null;
    }

    @Override
    public List<SeasonTicket> findAll() {
        logger.info("find all season tickets");
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("SELECT st FROM SeasonTicket st", SeasonTicket.class).getResultList();
        }catch (Exception e){
            logger.debug("Error find all {}", e);
        } return null;
    }

    @Override
    public void deleteById(int id) {
        logger.info("delete season ticket by id {}", id);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            SeasonTicket seasonTicket = session.load(SeasonTicket.class, id);
            session.delete(seasonTicket);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error delete season ticket by id {} - {}", id, e);
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
        logger.info("update season ticket {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error update season ticket {} - {}", entity,e);
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
        logger.info("save season ticket - {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error save season ticket {} - {}",entity, e );
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}
