package com.example.dao;

import com.example.HibernateSessionFactory;
import com.example.dao.daoApi.CityDao;
import com.example.entity.AbstractEntity;
import com.example.entity.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityDaoImpl implements CityDao {

    private final Logger logger = LoggerFactory.getLogger(CityDaoImpl.class);

    @Override
    public City findById(int id) {
        logger.info("find city by id {}",id);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        } catch (Exception e) {
            logger.debug("error find city by id {} - {}",id ,e);
        }
        return null;
    }

    @Override
    public List<City> findAll() {
        logger.info("find all cities");
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("SELECT c FROM City c", City.class).getResultList();
        } catch (Exception e) {
            logger.debug("error find all cities {}", e);
        } return null;
    }

    @Override
    public void deleteById(int id) {
        logger.info("delete city by id {}", id);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            City city = session.load(City.class, id);
            session.delete(city);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error delete city by id {} - {}", id, e);
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
        logger.info("update city - {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error update city {} - {}", entity, e);
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
        logger.info("save city {}", entity);
        Session session = HibernateSessionFactory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            logger.debug("error save city {} - {}", entity, e)  ;
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}
