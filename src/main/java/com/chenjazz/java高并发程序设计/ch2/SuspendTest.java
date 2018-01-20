package com.chenjazz.java高并发程序设计.ch2;

import org.junit.Test;

public class SuspendTest {
    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello：");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.suspend();
        System.out.println("suspend...3s");//挂起thread 3秒
        Thread.sleep(3000);
        thread.resume();
    }
}
