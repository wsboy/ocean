package com.wesboy.ocean.first.unsafe_sequence;

/**
 * @author: wangpengbo
 * @date: 2018/2/5
 */
public class UnsafeSequence implements Runnable {

    private int value;

    public int getNext() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value++;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(getNext());
    }
}
