package com.comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by daixuan on 2018/6/25 14:12
 */
@Configuration
public class DataSourceConfig {
    private final static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.hikari.primary")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.hikari.secondary")
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
