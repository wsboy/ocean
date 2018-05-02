package com.westboy.art.test1;

public class ThreadB extends Thread {

    private MyList list;

    public ThreadB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                //System.out.println("MyList.size" + list.size());
                if (list.size() == 5) {
                    System.out.println("==5 了，线程B要退出了");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
