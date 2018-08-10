package com.control;

import com.comment.AuthorityRequire;
import com.comment.ConfigManager;
import com.comment.util.HttpUtil;
import com.dao.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return "helloworld";
    }

    @GetMapping("/helloworld2")
    @AuthorityRequire("test2")
    public String helloworld2() {
        return "helloworld";
    }

    public static void main(String[] args) {
        String url = "http://android.myapp.com/myapp/detail.htm?apkName=com.shiqichuban.android";
        String response =  HttpUtil.getService(url);
        String regEx = "appName: \"(.*?)\"";
        Pattern pattern = Pattern.compile(regEx);// 匹配的模式
        Matcher m = pattern.matcher(response);
        while (m.find()) {
           System.out.println(m.group(1));
           return;
        }
    }
}
