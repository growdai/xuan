package com.dao;

import com.comment.BaseDao;
import com.control.TestControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by daixuan on 2018/6/26 15:06
 */
@Component("testdao")
public class TestDao extends BaseDao{
    private final static Logger logger = LoggerFactory.getLogger(TestDao.class);

    public void test(){
        System.out.println("124");
    }


}
