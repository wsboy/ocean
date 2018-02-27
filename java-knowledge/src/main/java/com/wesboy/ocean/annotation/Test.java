package com.wesboy.ocean.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: wangpengbo
 * @date: 2018/2/26
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class<?> clazz = TheClass.class;

        //类注解：方式一
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            print(annotation);
        }

        //类注解：方式二
        Annotation annotation = clazz.getAnnotation(MyAnnotation.class);
        print(annotation);

        //方法注解：方式一
        Method method = clazz.getMethod("doSomething", String.class);
        Annotation[] methodAnnotations = method.getDeclaredAnnotations();
        for (Annotation annotation1 : methodAnnotations) {
            print(annotation1);
        }

        //方法注解：方式二
        Annotation annotation1 =  method.getAnnotation(MyAnnotation.class);
        print(annotation1);

        //方法参数注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Class[] parameterTypes = method.getParameterTypes();

        int i = 0;
        for (Annotation[] annotations1 : parameterAnnotations) {
            Class parameterType = parameterTypes[i++];

            for (Annotation annotation2 : annotations1) {
                if (annotation2 instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) annotation2;
                    System.out.println("param: " + parameterType.getName());
                    System.out.println("name: " + myAnnotation.name());
                    System.out.println("value: " + myAnnotation.value());
                }
            }
        }

        //变量注解：方式一
        Field field = clazz.getField("myField");
        Annotation[] annotations1 =  field.getDeclaredAnnotations();
        for (Annotation annotation2 : annotations1) {
            print(annotation2);
        }

        //变量注解：方式二
        Annotation annotation2 = field.getAnnotation(MyAnnotation.class);
        print(annotation2);

    }

    private static void print(Annotation annotation) {
        if (annotation instanceof MyAnnotation) {
            MyAnnotation myAnnotation = (MyAnnotation) annotation;
            System.out.println("name: " + myAnnotation.name());
            System.out.println("value: " + myAnnotation.value());
        }
    }
}
