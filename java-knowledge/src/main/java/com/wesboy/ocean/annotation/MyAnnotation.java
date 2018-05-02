package com.wesboy.ocean.annotation;

import java.lang.annotation.*;

/**
 * @author: wangpengbo
 * @date: 2018/2/26
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
public @interface MyAnnotation {
    String name();

    String value();
}
