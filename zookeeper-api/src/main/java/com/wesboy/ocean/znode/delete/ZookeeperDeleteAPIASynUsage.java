package com.wesboy.ocean.znode.delete;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 异步删除
 *
 * @author: wangpengbo
 * @date: 2018/2/7
 */
public class ZookeeperDeleteAPIASynUsage implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("52.80.146.240:2181", 5000, new ZookeeperDeleteAPISynUsage());
        connectedSemaphore.await();
        String path = zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Success create znode: " + path);
        TimeUnit.SECONDS.sleep(5L);
        //执行删除操作
        zooKeeper.delete("/zk-test-ephemeral-", 0, new IVoidCallback(), "I am context");
        zooKeeper.close();
        System.out.println("ZkServer closed...");

    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event: " + watchedEvent);
        if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            connectedSemaphore.countDown();
        }
    }
}

class IVoidCallback implements AsyncCallback.VoidCallback {

    @Override
    public void processResult(int rc, String path, Object ctx) {
        //异步回调
        System.out.println("Create path result: [" + rc + ", " + path + ", " + ctx);
    }
}
