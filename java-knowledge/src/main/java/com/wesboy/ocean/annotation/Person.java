package com.wesboy.ocean.annotation;

import java.lang.annotation.Repeatable;

/**
 * @author: wangpengbo
 * @date: 2018/2/26
 */
@Repeatable(Persons.class)
public @interface Person {
    String role() default "";
}
