package com.example.dao;

import com.example.ApplicationTests;
import com.example.entity.SeasonTicket;
import com.example.entity.User;
import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SeasonTicketDaoTests {

    @Autowired
    private SeasonTicketDaoImpl seasonTicketDao;

    @Before
    public void init() throws SQLException, LiquibaseException {
        ApplicationTests.init();
    }

    @AfterClass
    public static void rewrite() throws SQLException, LiquibaseException {
        ApplicationTests.init().dropAll();
    }


    @Test
    public void findByIdTest() {
        SeasonTicket seasonTicket = seasonTicketDao.findById(1);
        Assert.assertNotNull(seasonTicket);
    }

    @Test
    public void findAllTest() {
        List<SeasonTicket> seasonTicketList = new ArrayList<>();
        List<SeasonTicket> listFromDB = seasonTicketDao.findAll();
        Assert.assertNotEquals(seasonTicketList, listFromDB);
        Assert.assertTrue(seasonTicketList.size() != listFromDB.size());
    }

    @Test
    public void deleteByIdTest() {
        List<SeasonTicket> seasonTicketsBefore = seasonTicketDao.findAll();
        SeasonTicket seasonTicket = seasonTicketDao.findById(2);
        seasonTicketDao.deleteById(2);
        List<SeasonTicket> seasonTicketsAfter = seasonTicketDao.findAll();
        Assert.assertNotEquals(seasonTicketsBefore, seasonTicketsAfter);
        Assert.assertTrue(seasonTicketsBefore.size() != seasonTicketsAfter.size());
        seasonTicket.setSeasonTicketId(2);
        seasonTicketDao.save(seasonTicket);
    }

    @Test
    public void updateTest() {
        SeasonTicket seasonTicket = seasonTicketDao.findById(1);
        int costPerHour = seasonTicket.getCostPerHour();
        seasonTicket.setCostPerHour(12);
        seasonTicketDao.update(seasonTicket);
        Assert.assertNotSame(costPerHour, seasonTicketDao.findById(1).getCostPerHour());
    }

    @Test
    public void saveTest() {
        List<SeasonTicket> seasonTicketsBefore = seasonTicketDao.findAll();
        User user = ApplicationTests.testUser(3);
        user.setUserId(3);
        SeasonTicket seasonTicket = new SeasonTicket(user);
        seasonTicketDao.save(seasonTicket);
        List<SeasonTicket> seasonTicketsAfter = seasonTicketDao.findAll();
        Assert.assertNotEquals(seasonTicketsBefore, seasonTicketsAfter);
        Assert.assertTrue(seasonTicketsBefore.size() != seasonTicketsAfter.size());
    }
}
