package com.wesboy.ocean.watcher;

/**
 * @author: wangpengbo
 * @date: 2018/2/9
 */
public class Caller {

    public MyCallInterface mc;

    public void setMc(MyCallInterface mc) {
        this.mc = mc;
    }

    public void call() {
        this.mc.method();
    }
}
