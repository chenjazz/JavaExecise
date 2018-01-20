package com.chenjazz.java高并发程序设计.ch3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock {
    private static ReentrantLock lock = new ReentrantLock();


    /**
     * 限时等待锁的使用(改成lambda了)
     */
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                if (lock.tryLock(3, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " : get lock success");
                    Thread.sleep(5000);
                } else {
                    System.out.println(Thread.currentThread().getName() + " : get lock fail");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " : release lock success");
                }
            }
        };

        new Thread(r, "t1").start();
        new Thread(r, "t2").start();
    }
}
