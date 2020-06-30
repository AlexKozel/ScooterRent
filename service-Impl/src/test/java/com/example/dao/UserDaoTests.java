package com.example.dao;


import com.example.ApplicationTests;
import com.example.entity.User;
import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTests {

    @Autowired
    private UserDaoImpl userDao;

    private final Logger logger = LoggerFactory.getLogger(UserDaoTests.class);

    @Before
    public void init() throws SQLException, LiquibaseException {
        ApplicationTests.init();
    }

    @AfterClass
    public static void rewrite() throws SQLException, LiquibaseException {
        ApplicationTests.init().dropAll();
    }

    @Test
    public void findByIdTest(){
        User user = userDao.findById(1);
        logger.info("founded user {}", user);
        Assert.assertNotNull(user);
    }

    @Test
    public void findAllTest(){
        List<User> userList = new ArrayList<>();
        List<User> listFromDB = userDao.findAll();
        Assert.assertNotEquals(userList, listFromDB);
        Assert.assertTrue(userList.size() != listFromDB.size());
    }

    @Test
    public void deleteByIdTest(){
        List<User> usersBefore = userDao.findAll();
        userDao.deleteById(2);
        List<User> usersAfter = userDao.findAll();
        Assert.assertNotEquals(usersBefore, usersAfter);
        Assert.assertTrue(usersBefore.size() != usersAfter.size());
    }

    @Test
    public void updateTest(){
        User user =  userDao.findById(1);
        String username = user.getFirstName();
        user.setFirstName("Vasia");
        userDao.update(user);
        Assert.assertNotSame(username, userDao.findById(1).getFirstName());
    }

    @Test
    public void saveTest(){
        List<User> usersBefore = userDao.findAll();
        User oldUser = usersBefore.get(0);
        User user = new User("Name", "Surname", oldUser.getLoginData());
        userDao.save(user);
        List<User> usersAfter = userDao.findAll();
        Assert.assertNotEquals(usersBefore, usersAfter);
        Assert.assertTrue(usersBefore.size() != usersAfter.size());
    }
}
