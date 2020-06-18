package com.example.dao;

import com.example.model.RentPoint;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RentPointDaoTests {

    @Autowired
    private RentPointDaoImpl rentPointDao;

    @Test
    public void findByIdTest(){
        RentPoint rentPoint = rentPointDao.findById(1);
        Assert.assertNotNull(rentPoint);
    }

    @Test
    public void findAllTest(){
        List<RentPoint> rentPoints = new ArrayList<>();
        List<RentPoint> listFromDB = rentPointDao.findAll();
        Assert.assertNotEquals(rentPoints, listFromDB);
        Assert.assertTrue(rentPoints.size() != listFromDB.size());
    }

    @Test
    public void deleteByIdTest(){
        List<RentPoint> rentPointsBefore = rentPointDao.findAll();
        rentPointDao.deleteById(2);
        List<RentPoint> rentPointsAfter = rentPointDao.findAll();
        Assert.assertNotEquals(rentPointsBefore, rentPointsAfter);
        Assert.assertTrue(rentPointsBefore.size() != rentPointsAfter.size());
    }

    @Test
    public void updateTest(){
        RentPoint rentPoint =  rentPointDao.findById(1);
        String address = rentPoint.getAddress();
        rentPoint.setAddress("minsk");
        rentPointDao.update(rentPoint);
        Assert.assertNotSame(address, rentPointDao.findById(1).getAddress());
        System.out.println(rentPointDao.findById(1).getAddress());
    }

    @Test
    public void saveTest(){
        List<RentPoint> rentPointsBefore = rentPointDao.findAll();
        RentPoint rentPoint = new RentPoint("Name", "Surname","123");
        rentPointDao.save(rentPoint);
        List<RentPoint> rentPointsAfter = rentPointDao.findAll();
        Assert.assertNotEquals(rentPointsBefore, rentPointsAfter);
        Assert.assertTrue(rentPointsBefore.size() != rentPointsAfter.size());
    }
}