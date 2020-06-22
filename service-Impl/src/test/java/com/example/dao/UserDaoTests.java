package com.example.dao;


import com.example.entity.LoginData;
import com.example.entity.User;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTests {

    @Autowired
    private UserDaoImpl userDao;

    @Before
    public void init() throws SQLException, LiquibaseException {
        // Prepare the Hibernate configuration
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources metaDataSrc = new MetadataSources(reg);

        // Get database connection
        Connection con = metaDataSrc.getServiceRegistry().getService(ConnectionProvider.class).getConnection();
        JdbcConnection jdbcCon = new JdbcConnection(con);

        // Initialize Liquibase and run the update
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcCon);
        Liquibase liquibase = new Liquibase("db/changelog/db.changelog-master.yaml", new ClassLoaderResourceAccessor(), database);
        liquibase.update("test");
    }

    @Test
    public void findByIdTest(){
        User user = userDao.findById(1);
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
        userDao.deleteById(4);
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
        System.out.println(userDao.findById(1).getFirstName());
    }

    @Test
    public void saveTest(){
        List<User> usersBefore = userDao.findAll();
        User user = new User("Name", "Surname", true, new LoginData());
        userDao.save(user);
        List<User> usersAfter = userDao.findAll();
        Assert.assertNotEquals(usersBefore, usersAfter);
        Assert.assertTrue(usersBefore.size() != usersAfter.size());
    }
}
