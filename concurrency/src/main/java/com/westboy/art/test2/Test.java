package com.westboy.art.test2;


public class Test {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.setName("A");
        a.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadB b = new ThreadB(lock);
        b.setName("B");
        b.start();
    }
}
