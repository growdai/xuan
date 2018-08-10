package com.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by daixuan on 2018/6/25 11:09
 */
public class BaseDao{
    @Autowired
    @Qualifier("zcdspv4JdbcTemplate")
    private JdbcTemplate zcdspv4JdbcTemplate;

    @Autowired
    @Qualifier("adpushadtotalv4JdbcTemplate")
    private JdbcTemplate adpushadtotalv4JdbcTemplate;

    public JdbcTemplate getZcdspv4JdbcTemplate() {
        return zcdspv4JdbcTemplate;
    }

    public void setZcdspv4JdbcTemplate(JdbcTemplate zcdspv4JdbcTemplate) {
        this.zcdspv4JdbcTemplate = zcdspv4JdbcTemplate;
    }

    public JdbcTemplate getAdpushadtotalv4JdbcTemplate() {
        return adpushadtotalv4JdbcTemplate;
    }

    public void setAdpushadtotalv4JdbcTemplate(JdbcTemplate adpushadtotalv4JdbcTemplate) {
        this.adpushadtotalv4JdbcTemplate = adpushadtotalv4JdbcTemplate;
    }
}
