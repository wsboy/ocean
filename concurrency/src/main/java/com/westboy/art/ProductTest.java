package com.westboy.art;

public class ProductTest {

    static class Clerk {
        private static final int MAX_PRODUCT = 20;
        private static final int MIN_PRODUCT = 0;

        private int product = 0;

        public synchronized void addProduct() {
            if (this.product >= MAX_PRODUCT) {
                try {
                    wait();
                    System.out.println("产品已满，请稍后再生产");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }

            this.product++;

            System.out.println("生产者生产了第" + this.product + "个产品");
            notifyAll();
        }

        public synchronized void getProduct() {
            if (this.product <= MIN_PRODUCT) {
                try {
                    wait();
                    System.out.println("产品处于缺货状态");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }

            System.out.println("消费者消费了第" + this.product + "个产品");
            this.product--;

            notifyAll();
        }

        static class Producer implements Runnable {

            private Clerk clerk;

            public Producer(Clerk clerk) {
                this.clerk = clerk;
            }

            @Override
            public void run() {
                System.out.println("生产者开始生产产品");
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    clerk.addProduct();
                }
            }
        }

        static class Consumer implements Runnable {

            private Clerk clerk;

            public Consumer(Clerk clerk) {
                this.clerk = clerk;
            }

            @Override
            public void run() {
                System.out.println("消费者开始消费产品");
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    clerk.getProduct();
                }
            }
        }

        public static void main(String[] args) {
            Clerk clerk = new Clerk();
            Thread producerThread = new Thread(new Producer(clerk));
            Thread consumerThread = new Thread(new Consumer(clerk));

            producerThread.start();
            consumerThread.start();
        }
    }
}
