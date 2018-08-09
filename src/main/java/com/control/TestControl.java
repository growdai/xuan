package com.control;

import com.comment.AuthorityRequire;
import com.comment.ConfigManager;
import com.dao.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daixuan on 2018/6/25 10:56
 */
@RestController
public class TestControl {
    private final static Logger logger = LoggerFactory.getLogger(TestControl.class);
    @Autowired
    @Qualifier("testdao")
    private TestDao testDao;
    @Autowired
    private ConfigManager configManager;

    @GetMapping("/helloworld")
    @AuthorityRequire("test")
    public String helloworld() {
        System.out.print(configManager.getTest());
        testDao.test();
        return "helloworld";
    }

    @GetMapping("/helloworld2")
    @AuthorityRequire("test2")
    public String helloworld2() {
        testDao.test2();
        return "helloworld";
    }
}
