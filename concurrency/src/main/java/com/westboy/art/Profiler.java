package com.westboy.art;

import java.util.concurrent.TimeUnit;

public class Profiler {

    private static final ThreadLocal<Long> LONG_THREAD_LOCAL = ThreadLocal.withInitial(System::currentTimeMillis);

    private static void begin(){
        LONG_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    private static long end() {
        return System.currentTimeMillis() - LONG_THREAD_LOCAL.get();
    }

    public static void main(String[] args) {
        Profiler.begin();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}
