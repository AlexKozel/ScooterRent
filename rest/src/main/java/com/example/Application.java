package com.example;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.service.UserService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@SpringBootApplication(scanBasePackages = "com.example")
@RestController
public class Application {

    public final UserService service;

    public Application(@Autowired UserService service) {
        this.service = service;
    }

    @GetMapping("/home")
    public String home() {
        System.out.println("create a discount");
//        service.save();
        System.out.println("discount added");
//        System.out.println(new City().toString());
        return service.message();

    }

    @GetMapping("/")
//    public ResponseEntity<String> getUser(@RequestHeader("authorization") Map<String, String> map){
        public String getUser(){
//        System.out.println(map);
        String s = "greeting";
        return s;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration page";
    }

    public static void main(String[] args) throws LiquibaseException, SQLException {
        SpringApplication.run(Application.class, args);

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

}