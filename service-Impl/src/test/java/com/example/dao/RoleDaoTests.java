package com.example.dao;

import com.example.ApplicationTests;
import com.example.entity.Role;
import liquibase.exception.LiquibaseException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleDaoTests {

    @Autowired
    private RoleDaoImpl roleDao;

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
        Role role = roleDao.findById(1);
        Assert.assertNotNull(role);
    }

    @Test
    public void findAllTest(){
        List<Role> roles = new ArrayList<>();
        List<Role> listFromDB = roleDao.findAll();
        Assert.assertNotEquals(roles, listFromDB);
        Assert.assertTrue(roles.size() != listFromDB.size());
    }

    @Test
    public void deleteByIdTest(){
        List<Role> rolesBefore = roleDao.findAll();
        roleDao.deleteById(2);
        List<Role> rolesAfter = roleDao.findAll();
        Assert.assertNotEquals(rolesBefore, rolesAfter);
        Assert.assertTrue(rolesBefore.size() != rolesAfter.size());
    }

    @Test
    public void updateTest(){
        Role role =  roleDao.findById(1);
        String roleName = role.getName();
        role.setName("anon");
        roleDao.update(role);
        Assert.assertNotSame(roleName, roleDao.findById(1).getName());
    }

    @Test
    public void saveTest(){
        List<Role> rolesBefore = roleDao.findAll();
        Role role = new Role("SUDO");
        roleDao.save(role);
        List<Role> rolesAfter = roleDao.findAll();
        Assert.assertNotEquals(rolesBefore, rolesAfter);
        Assert.assertTrue(rolesBefore.size() != rolesAfter.size());
    }
}