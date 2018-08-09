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
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            Thread.sleep(1000*10*60);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        logger.info("------------测试--------------------");
                    }
                }
            });
            thread.start();
    }

    public void test2(){
        String sql = "INSERT INTO test (name,email) VALUES ('test1','183168250722@qq.com')";
        this.getSecondaryJdbcTemplate().batchUpdate(sql);
    }
}
