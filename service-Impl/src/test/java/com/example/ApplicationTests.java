package com.example;

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
    public void contextLoads() throws SQLException, LiquibaseException {
        init();
    }

    public static User testUser(int id){
        User user = new User( "qwer", "qwer",new LoginData("qwer", "qwer"));
        user.setUserId(id);
        return user;
    }

    public static Liquibase init() throws LiquibaseException, SQLException{
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
        return liquibase;


//
//// Create Hibernate SessionFactory
//        SessionFactory sf = metaDataSrc.addAnnotatedClass(User.class).addAnnotatedClass(RentStory.class).buildMetadata().buildSessionFactory();
    }
}