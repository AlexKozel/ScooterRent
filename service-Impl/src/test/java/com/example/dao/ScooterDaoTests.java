package com.example.dao;


import com.example.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.example.model.ScooterStatus.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ScooterDaoTests {

    private Logger logger = LoggerFactory.getLogger(ScooterDaoTests.class);

    @Autowired
    private ScooterDaoImpl scooterDao;
    @Autowired
    private RentPointDaoImpl rentPointDao;

    @Test
    public void findByIdTest(){
        Scooter scooter = scooterDao.findById(1);
        Assert.assertNotNull(scooter);
    }

    @Test
    public void findAllTest(){
        List<Scooter> scooterList = new ArrayList<>();
        List<Scooter> listFromDB = scooterDao.findAll();
        Assert.assertNotEquals(scooterList, listFromDB);
        Assert.assertTrue(scooterList.size() != listFromDB.size());
    }

    @Test
    public void deleteByIdTest(){
        List<Scooter> scooterBefore = scooterDao.findAll();
        scooterDao.deleteById(1);
        List<Scooter> scooterAfter = scooterDao.findAll();
        Assert.assertNotEquals(scooterBefore, scooterAfter);
        Assert.assertTrue(scooterBefore.size() != scooterAfter.size());
    }

    @Test
    public void updateTest(){
        Scooter scooter =  scooterDao.findById(1);
        String scooterModel = scooter.getModel();
        scooter.setModel("newScooter");
        scooterDao.update(scooter);
        Assert.assertNotSame(scooterModel, scooterDao.findById(1).getModel());
        System.out.println(scooterDao.findById(1).getModel());
    }

    @Test
    public void saveTest(){
        List<Scooter> scooterBefore = scooterDao.findAll();
        Scooter scooter = new Scooter();
        scooter.setModel("megaJet");
        scooter.setStatus(BROKEN);
        scooter.setRentPoint(rentPointDao.findById(1));
        logger.info("save th entity - {}", scooter);
        scooterDao.save(scooter);
        List<Scooter> scooterAfter = scooterDao.findAll();
        Assert.assertNotEquals(scooterBefore, scooterAfter);
        Assert.assertTrue(scooterBefore.size() != scooterAfter.size());
    }
}
