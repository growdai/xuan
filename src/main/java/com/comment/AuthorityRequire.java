package com.comment;

import org.apache.commons.lang.StringUtils;

import java.lang.annotation.*;

/**
 * Created by daixuan on 2018/6/25 15:50
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface AuthorityRequire {
    String[] value() default StringUtils.EMPTY;
}
