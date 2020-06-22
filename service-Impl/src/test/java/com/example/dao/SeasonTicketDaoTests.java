package com.example.dao;


import com.example.entity.SeasonTicket;
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
public class SeasonTicketDaoTests {

    @Autowired
    private SeasonTicketDaoImpl seasonTicketDao;

    @Test
    public void findByIdTest(){
        SeasonTicket seasonTicket = seasonTicketDao.findById(1);
        Assert.assertNotNull(seasonTicket);
    }

    @Test
    public void findAllTest(){
        List<SeasonTicket> seasonTicketList = new ArrayList<>();
        List<SeasonTicket> listFromDB = seasonTicketDao.findAll();
        Assert.assertNotEquals(seasonTicketList, listFromDB);
        Assert.assertTrue(seasonTicketList.size() != listFromDB.size());
    }

    @Test
    public void deleteByIdTest(){
        List<SeasonTicket> usersBefore = seasonTicketDao.findAll();
        seasonTicketDao.deleteById(2);
        List<SeasonTicket> usersAfter = seasonTicketDao.findAll();
        Assert.assertNotEquals(usersBefore, usersAfter);
        Assert.assertTrue(usersBefore.size() != usersAfter.size());
    }

    @Test
    public void updateTest(){
        SeasonTicket seasonTicket =  seasonTicketDao.findById(1);
        int costPerHour = seasonTicket.getCostPerHour();
        seasonTicket.setCostPerHour(12);
        seasonTicketDao.update(seasonTicket);
        Assert.assertNotSame(costPerHour, seasonTicketDao.findById(1).getCostPerHour());
        System.out.println(seasonTicketDao.findById(1).getCostPerHour());
    }

    @Test
    public void saveTest(){
        List<SeasonTicket> usersBefore = seasonTicketDao.findAll();
        SeasonTicket seasonTicket = new SeasonTicket();
        seasonTicketDao.save(seasonTicket);
        List<SeasonTicket> usersAfter = seasonTicketDao.findAll();
        Assert.assertNotEquals(usersBefore, usersAfter);
        Assert.assertTrue(usersBefore.size() != usersAfter.size());
    }
}
