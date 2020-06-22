package com.example.dao;


import com.example.entity.LoginData;
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
public class LoginDaoImplTests {

    @Autowired
    private LoginDaoImpl loginDao;

    @Test
    public void findByIdTest(){
        LoginData user = loginDao.findById(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void findAllTest(){
        List<LoginData> loginDataList = new ArrayList<>();
        List<LoginData> listFromDB = loginDao.findAll();
        Assert.assertNotEquals(loginDataList, listFromDB);
        Assert.assertTrue(loginDataList.size() != listFromDB.size());
    }

    @Test
    public void deleteByIdTest(){
        List<LoginData> loginBefore = loginDao.findAll();
        loginDao.deleteById(2);
        List<LoginData> loginAfter = loginDao.findAll();
        Assert.assertNotEquals(loginBefore, loginAfter);
        Assert.assertTrue(loginBefore.size() != loginAfter.size());
    }

    @Test
    public void updateTest(){
        LoginData loginData =  loginDao.findById(1);
        String login = loginData.getLogin();
        loginData.setLogin("newLogin");
        loginDao.update(loginData);
        Assert.assertNotSame(login, loginDao.findById(1).getLogin());
        System.out.println(loginDao.findById(1).getLogin());
    }

    @Test
    public void saveTest(){
        List<LoginData> loginBefore = loginDao.findAll();
        LoginData loginData = new LoginData("newLogin","newPassword");
        loginDao.save(loginData);
        List<LoginData> loginAfter = loginDao.findAll();
        Assert.assertNotEquals(loginBefore, loginAfter);
        Assert.assertTrue(loginBefore.size() != loginAfter.size());
    }
}
