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
    @Bean(name = "zcdspv4DataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.hikari.zcdspv4")
    public DataSource zcdspv4DataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "adpushadtotalv4")
    @ConfigurationProperties(prefix="spring.datasource.hikari.adpushadtotalv4")
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "zcdspv4JdbcTemplate")
    public JdbcTemplate zcdspv4JdbcTemplate(
            @Qualifier("zcdspv4DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "adpushadtotalv4JdbcTemplate")
    public JdbcTemplate adpushadtotalv4JdbcTemplate(
            @Qualifier("adpushadtotalv4") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
