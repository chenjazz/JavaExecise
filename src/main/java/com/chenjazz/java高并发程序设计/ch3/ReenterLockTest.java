package com.chenjazz.java高并发程序设计.ch3;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockTest implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000_0000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockTest reenterLock = new ReenterLockTest();

        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }
}
