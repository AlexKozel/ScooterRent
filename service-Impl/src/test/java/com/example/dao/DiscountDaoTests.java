package com.example.dao;

import com.example.model.Discount;
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
public class DiscountDaoTests {

    @Autowired
    private DiscountDaoImpl discountDao;

    @Test
    public void findByIdTest(){
        Discount discount = discountDao.findById(1);
        Assert.assertNotNull(discount);
    }

    @Test
    public void findAllTest(){
        List<Discount> discountList = new ArrayList<>();
        List<Discount> listFromDB = discountDao.findAll();
        Assert.assertNotEquals(discountList, listFromDB);
        Assert.assertTrue(discountList.size() != listFromDB.size());
    }

    @Test
    public void deleteByIdTest(){
        List<Discount> discountBefore = discountDao.findAll();
        discountDao.deleteById(2);
        List<Discount> discountAfter = discountDao.findAll();
        Assert.assertNotEquals(discountBefore, discountAfter);
        Assert.assertTrue(discountBefore.size() != discountAfter.size());
    }

    @Test
    public void updateTest(){
        Discount discount =  discountDao.findById(1);
        Integer discountRate = discount.getDiscountRate();
        discount.setDiscountRate(25);
        discountDao.update(discount);
        Assert.assertNotSame(discountRate, discountDao.findById(1).getDiscountRate());
        System.out.println(discountDao.findById(1).getDiscountRate());
    }

    @Test
    public void saveTest(){
        List<Discount> discountBefore = discountDao.findAll();
        Discount discount = new Discount(25);
        discountDao.save(discount);
        List<Discount> usersAfter = discountDao.findAll();
        Assert.assertNotEquals(discountBefore, usersAfter);
        Assert.assertTrue(discountBefore.size() != usersAfter.size());
    }
}
