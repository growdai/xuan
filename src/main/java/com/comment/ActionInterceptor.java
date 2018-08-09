package com.comment;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;
import java.util.Arrays;

/**
 * 拦截器,权限控制
 * Created by daixuan on 2018/6/26 13:15
 */
public class ActionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return false;
        }
        HandlerMethod  handlerMethod= (HandlerMethod) handler;
        //获取方法
        Method method=handlerMethod.getMethod();
        //拿到自定义注解的值
        AuthorityRequire authorization=method.getAnnotation(AuthorityRequire.class);
        String[] value=  authorization.value();
        if(value==null){
            //这里取缓存里头的用户权限数组，做比较
            PrintWriter writer = response.getWriter();
            writer.write("权限不足!");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
