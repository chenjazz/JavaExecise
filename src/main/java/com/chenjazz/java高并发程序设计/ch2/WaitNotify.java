package com.chenjazz.java高并发程序设计.ch2;

import org.junit.Test;

/**
 * 2.2.4 自定义demo
 */
public class WaitNotify {
    static final Object object = new Object();

    @Test
    public void test() throws InterruptedException {
        Runnable task1 = () -> {
            System.out.println("task1 start");
            synchronized (object) {
                System.out.println("task1 enter lock");
                try {
                    Thread.sleep(1000);
                    System.out.println("task1 wait");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task1 is notified by task2");
            }

        };
        Runnable task2 = () -> {
            System.out.println("task2 start");
            synchronized (object) {
                System.out.println("task2 enter lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task2 start");
                object.notify();
            }

        };

        new Thread(task1).start();
        new Thread(task2).start();

        Thread.sleep(5000);
    }
}
