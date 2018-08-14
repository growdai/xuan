package com.application;

import com.DemoApplication;
import com.comment.util.HttpUtil;
import com.dao.TestDao;
import com.model.AppNewDto;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= DemoApplication.class)// 指定spring-boot的启动类
public class DemoApplicationTests {
	@Autowired
	@Qualifier("testdao")
	private TestDao testDao;
	@Test
	public void contextLoads() {
		List<AppNewDto> appNewDtoList =  testDao.appNewDtos();
		List<AppNewDto> appNewDtos = Lists.newArrayList();
		if (appNewDtoList==null){
			return;
		}
		int num = 0;
		for (AppNewDto c:appNewDtoList){
			num++;
			String url = "http://android.myapp.com/myapp/detail.htm?apkName="+c.getPackage_name();
			String response =  HttpUtil.getService(url);
			String regEx = "appName: \"(.*?)\"";
			Pattern pattern = Pattern.compile(regEx);// 匹配的模式
			Matcher m = pattern.matcher(response);
			if (appNewDtos.size()==100){
				testDao.batchUpdate(appNewDtos);
				appNewDtos.clear();
			}
			while (m.find()) {
				if (StringUtils.isNotBlank(m.group(1))){
					AppNewDto appNewDto = new AppNewDto();
					appNewDto.setPackage_name(c.getPackage_name());
					appNewDto.setApp_name(m.group(1));
					appNewDtos.add(appNewDto);
					System.out.println(m.group(1)+"--"+num);
				}
				continue;
			}
		}
		testDao.batchUpdate(appNewDtos);
	}


}
