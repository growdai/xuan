package com.application;

import com.DemoApplication;
import com.dao.TestDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= DemoApplication.class)// 指定spring-boot的启动类
public class DemoApplicationTests {
	@Autowired
	@Qualifier("testdao")
	private TestDao testDao;
	@Test
	public void contextLoads() {
		testDao.test();
	}

}
