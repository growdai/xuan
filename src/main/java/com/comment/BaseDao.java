package com.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by daixuan on 2018/6/25 11:09
 */
public class BaseDao{
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate secondaryJdbcTemplate;

    public JdbcTemplate getPrimaryJdbcTemplate() {
        return primaryJdbcTemplate;
    }

    public void setPrimaryJdbcTemplate(JdbcTemplate primaryJdbcTemplate) {
        this.primaryJdbcTemplate = primaryJdbcTemplate;
    }

    public JdbcTemplate getSecondaryJdbcTemplate() {
        return secondaryJdbcTemplate;
    }

    public void setSecondaryJdbcTemplate(JdbcTemplate secondaryJdbcTemplate) {
        this.secondaryJdbcTemplate = secondaryJdbcTemplate;
    }
}
