package com.westboy.art;

public class NotifyWaitTest {
    private final static Object lock = new Object();
    private static boolean flag = false;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new ThreadWait().start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new ThreadA().start();

        new ThreadNotify().start();

    }

    private static class ThreadWait extends Thread {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("线程" + getName() + "即将等待");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程" + getName() + "结束");
            }
        }
    }

    private static class ThreadA extends Thread {

        @Override
        public void run() {
            while (!flag) {
                yield();
            }
            synchronized (lock) {
                System.out.println("ThreadA抢到了锁");
            }
        }
    }

    private static class ThreadNotify extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("notify线程抢到了锁");
                lock.notifyAll();
                flag = true;
            }
        }
    }



}
