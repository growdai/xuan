package com.comment;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daixuan on 2018/6/25 15:07
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean filterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new AuthFilter());
        frBean.addUrlPatterns("/*");
        frBean.setOrder(Integer.MAX_VALUE);
        return frBean;
    }
}
