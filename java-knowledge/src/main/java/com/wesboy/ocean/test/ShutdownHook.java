package com.wesboy.ocean.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.stream.IntStream;

public class ShutdownHook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(ShutdownHook::run));
        IntStream.range(0, 3).forEach(i -> {
            try {
                System.out.println(i + " 正在工作...");
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void run() {
        String path = ShutdownHook.class.getResource("/hook.log").getPath();
        System.out.println(path);
        try (FileWriter fw = new FileWriter(path)) {
            // 假设记录日志/或者发送消息
            fw.write("完成销毁操作,回收内存! " + (new Date()).toString());
            System.out.println("退出程序...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
