package com.chenjazz.java高并发程序设计.ch2;

import com.rabbitmq.client.UnblockedCallback;
import org.junit.Test;

/**
 * 来自于2.2.1
 */
public class NewThread {
    @Test
    public void newThread() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
    }

    @Test
    public void newThread2() throws InterruptedException {
        Runnable task = () -> System.out.println("Hello");
        new Thread(task).run();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_0000; i++) {
            Thread thread = new Thread(task);
            thread.run();
//            thread.join();
        }
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }
}
