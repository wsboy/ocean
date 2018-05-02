package com.wesboy.ocean.test;

public class TestJoin {
    public static void main(String[] args) {
        Thread t1 = new MyThread("线程1");
        Thread t2 = new MyThread("线程2");
        Thread t3 = new MyThread("线程3");

        try {
            //t1先启动
            t1.start();
            t1.join();
            //t2
            t2.start();
            t2.join();
            //t3
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

