package com.comment;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 注册拦截器，指定拦截路径
 * Created by daixuan on 2018/6/26 13:35
 */
@SpringBootConfiguration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ActionInterceptor()).addPathPatterns("/**");
    }
}
