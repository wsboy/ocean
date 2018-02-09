package com.wesboy.ocean.znode.create;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * @author: wangpengbo
 * @date: 2018/2/6
 */
public class ZookeeperCreateAPISyncUsage implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("52.80.146.240:2181", 5000, new ZookeeperCreateAPISyncUsage());
        connectedSemaphore.await();
        String path1 = zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Success create znode: " + path1);
        String path2 = zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("Success create znode: " + path2);
        zooKeeper.close();
        System.out.println("ZkServer closed...");
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event: " + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            connectedSemaphore.countDown();
        }
    }
}
