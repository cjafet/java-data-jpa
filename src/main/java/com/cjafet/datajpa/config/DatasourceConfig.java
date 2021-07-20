package com.cjafet.datajpa.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

//@Configuration
public class DatasourceConfig {

    // @ConfigurationProperties("foo.datasource")
    // You can also combine properties and programmatic configuration by using
    // the @ConfigurationProperties annotation. Spring will attempt to inject any properties
    // found beginning with the provided prefix into the returned @Bean.


    // The @Bean annotation marks methods that should create beans during Spring initialization.
    // Each method will be executed and the returned object will be added as a Bean for Spring to use in dependency injection.
    // Spring will inject this DataSource whenever a DataSource is requested
//    @Bean
//    public DataSource getDatasource(DataSourceProperties properties) {
//        DataSourceBuilder dsb = DataSourceBuilder.create();
//        dsb.username("sa");
//        dsb.password("sa123456");
//        dsb.url("jdbc:mysql://localhost:3306/plant");
//        return dsb.build();
//    }
//
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix="com.plants.datasource")
//    public DataSource getDatasource() {
//        DataSourceBuilder dsb = DataSourceBuilder.create();
//        dsb.username("sa");
//        dsb.password("sa123456");
//        return dsb.build();
//    }

}
