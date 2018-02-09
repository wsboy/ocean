package com.wesboy.ocean.watcher;

/**
 * @author: wangpengbo
 * @date: 2018/2/9
 */
public class CallbackClass implements MyCallInterface{

    @Override
    public void method() {
        System.out.println("回调函数");
    }

    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.setMc(new CallbackClass());
        caller.call();
    }
}
