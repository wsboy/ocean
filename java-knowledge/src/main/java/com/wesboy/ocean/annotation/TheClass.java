package com.wesboy.ocean.annotation;

/**
 * @author: wangpengbo
 * @date: 2018/2/26
 */
@MyAnnotation(name = "className", value = "classValue")
public class TheClass {


    @MyAnnotation(name = "fieldName", value = "fieldValue")
    public String myField = null;

    @MyAnnotation(name = "methodName", value = "methodValue")
    public void doSomething(@MyAnnotation(name = "parameterName", value = "parameterValue") String string) {

    }
}
