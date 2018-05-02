package com.westboy.art.test1;

public class Test {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        MyList service = new MyList();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

    }
}
