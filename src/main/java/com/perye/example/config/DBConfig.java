package com.perye.example.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;

/**
 * @author: Perye
 * @create: 2018-10-23 20:35
 **/
@Configuration
public class DBConfig {
    @Autowired
    private Environment environment;

    @Bean(name = "dataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(environment.getProperty("perye.db.driverClassName"));
        dataSource.setJdbcUrl(environment.getProperty("perye.db.url"));
        dataSource.setUser(environment.getProperty("perye.db.username"));
        dataSource.setPassword(environment.getProperty("perye.db.password"));
        dataSource.setMaxPoolSize(20);
        dataSource.setMinPoolSize(5);
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxIdleTime(300);
        dataSource.setAcquireIncrement(5);
        dataSource.setIdleConnectionTestPeriod(60);
        return dataSource;
    }
}
