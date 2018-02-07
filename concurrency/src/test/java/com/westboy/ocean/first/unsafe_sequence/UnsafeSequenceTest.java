package com.westboy.ocean.first.unsafe_sequence;

import org.junit.Test;

/**
 * @author: wangpengbo
 * @date: 2018/2/5
 */
public class UnsafeSequenceTest {

    @Test
    public void test() throws Exception {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(unsafeSequence, "thread" + i);
            thread.start();
        }

        Thread.sleep(5000);
    }
}