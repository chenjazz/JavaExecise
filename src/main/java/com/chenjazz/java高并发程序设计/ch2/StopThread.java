package com.chenjazz.java高并发程序设计.ch2;

import org.junit.Test;

/**
 * 根据2.2.2 改动
 */
public class StopThread {
    volatile static boolean isStop = false;

    @Test
    public void stop() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.print("Hello ");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("World");
                if (isStop) {
                    break;
                }
            }
            System.out.println("已终止");
        });
        thread.start();
        Thread.sleep(1000);
        isStop = true;
        Thread.sleep(5000);//模拟其他运行代码
    }
}
