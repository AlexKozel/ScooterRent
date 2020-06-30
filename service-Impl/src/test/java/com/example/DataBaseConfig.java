package com.example;

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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DataBaseConfig {

    @Bean
    public Liquibase getLiquibase() throws LiquibaseException, SQLException {
        // Prepare the Hibernate configuration
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources metaDataSrc = new MetadataSources(reg);

// Get database connection
        Connection con = metaDataSrc.getServiceRegistry().getService(ConnectionProvider.class).getConnection();
        JdbcConnection jdbcCon = new JdbcConnection(con);

// Initialize Liquibase and run the update
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcCon);
        Liquibase liquibase = new Liquibase("db/changelog/db.changelog-master.yaml", new ClassLoaderResourceAccessor(), database);
        return liquibase;

    }
}
