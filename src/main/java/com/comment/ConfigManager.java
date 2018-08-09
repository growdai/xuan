package com.comment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置文件值
 * Created by daixuan on 2018/6/26 15:35
 */
@Component
public class ConfigManager {
    @Value("${test}")
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
