package com.wesboy.ocean;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author: wangpengbo
 * @date: 2018/2/6
 */
public class ZookeeperUsageSimple implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) {

        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper("52.80.146.240:2181", 5000, new ZookeeperUsageSimple());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (zooKeeper != null) {
            System.out.println(zooKeeper.getState());
            try {
                connectedSemaphore.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Zookeeper session established.");

    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event: " + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            connectedSemaphore.countDown();
        }
    }
}
