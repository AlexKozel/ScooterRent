package com.example.dao;

import com.example.ApplicationTests;
import com.example.entity.City;
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
public class CityDaoTests {

    @Autowired
    private CityDaoImpl cityDao;

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
        City city = cityDao.findById(1);
        Assert.assertNotNull(city);
    }

    @Test
    public void findAllTest() {
        List<City> cityList = new ArrayList<>();
        List<City> listFromDB = cityDao.findAll();
        Assert.assertNotEquals(cityList, listFromDB);
        Assert.assertTrue(cityList.size() != listFromDB.size());
    }

    @Test
    public void deleteByIdTest() {
        List<City> cityBefore = cityDao.findAll();
        cityDao.deleteById(2);
        List<City> cityAfter = cityDao.findAll();
        Assert.assertNotEquals(cityBefore, cityAfter);
        Assert.assertTrue(cityBefore.size() != cityAfter.size());
    }

    @Test
    public void updateTest() {
        City city = cityDao.findById(1);
        String cityName = city.getCityName();
        city.setCityName("Minsk");
        cityDao.update(city);
        Assert.assertNotSame(cityName, cityDao.findById(1).getCityName());
    }

    @Test
    public void saveTest() {
        List<City> cityBefore = cityDao.findAll();
        City city = new City("Brest");
        cityDao.save(city);
        List<City> cityAfter = cityDao.findAll();
        Assert.assertNotEquals(cityBefore, cityAfter);
        Assert.assertTrue(cityBefore.size() != cityAfter.size());
    }
}
