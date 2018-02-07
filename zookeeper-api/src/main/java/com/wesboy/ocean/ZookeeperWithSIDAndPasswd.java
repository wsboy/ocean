package com.wesboy.ocean;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author: wangpengbo
 * @date: 2018/2/6
 */
public class ZookeeperWithSIDAndPasswd implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("52.80.146.240:2181", 5000, new ZookeeperWithSIDAndPasswd());

        connectedSemaphore.await();

        long sessionId = zooKeeper.getSessionId();
        byte[] passwd = zooKeeper.getSessionPasswd();

        //Use illegal sessionId and sessionPasswd
        zooKeeper = new ZooKeeper("52.80.146.240:2181", 5000, new ZookeeperUsageSimple(), 1L, "test".getBytes());
        //Use correct sessionId and sessionPasswd
        zooKeeper = new ZooKeeper("52.80.146.240:2181", 5000, new ZookeeperUsageSimple(), sessionId, passwd);

        Thread.sleep(Integer.MAX_VALUE);

    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event: " + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            connectedSemaphore.countDown();
        }
    }
}
