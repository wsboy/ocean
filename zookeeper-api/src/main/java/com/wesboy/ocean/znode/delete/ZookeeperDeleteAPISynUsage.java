package com.wesboy.ocean.znode.delete;

import org.apache.zookeeper.*;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 同步删除
 *
 * @author: wangpengbo
 * @date: 2018/2/7
 */

public class ZookeeperDeleteAPISynUsage implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("52.80.146.240:2181", 5000, new ZookeeperDeleteAPISynUsage());
        connectedSemaphore.await();
        String path = zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Success create znode: " + path);
        TimeUnit.SECONDS.sleep(5L);




        //执行删除操作，-1：表示跳过版本检查
        zooKeeper.delete("/zk-test-ephemeral-", -1);

        TimeUnit.SECONDS.sleep(5L);
        //关闭连接
        zooKeeper.close();
        System.out.println("ZkServer closed...");
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Time: " + new Date() + "Receive watched event: " + watchedEvent);
        if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                connectedSemaphore.countDown();
            } else if (Event.EventType.NodeDeleted == watchedEvent.getType()) {
                System.out.println("Success delete znode:" + watchedEvent.getPath());
            }
        }
    }
}
