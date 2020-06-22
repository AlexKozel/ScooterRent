package com.example;

import com.example.entity.RentStory;
import com.example.entity.User;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Connection;
import java.sql.SQLException;

@ActiveProfiles("test")
@SpringBootApplication
//@RunWith(SpringRunner.class)
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }



//    @Before
//    public void init() throws LiquibaseException, SQLException{
//        // Prepare the Hibernate configuration
//        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
//        MetadataSources metaDataSrc = new MetadataSources(reg);
//
//// Get database connection
//        Connection con = metaDataSrc.getServiceRegistry().getService(ConnectionProvider.class).getConnection();
//        JdbcConnection jdbcCon = new JdbcConnection(con);
//
//// Initialize Liquibase and run the update
//        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcCon);
//        Liquibase liquibase = new Liquibase("db.changelog.xml", new ClassLoaderResourceAccessor(), database);
//        liquibase.update("test");
//
//// Create Hibernate SessionFactory
//        SessionFactory sf = metaDataSrc.addAnnotatedClass(User.class).addAnnotatedClass(RentStory.class).buildMetadata().buildSessionFactory();
//    }
}