package com.chenjazz.thinking.ch21_3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Jiazhi
 * 2016/4/13
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("trylock()" + captured);
        } finally {
            if (captured)
                lock.unlock();
        }

    }

    public void timed() {
        boolean capture = false;
        try {
            capture = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS)" + capture);

        } finally {
            if (capture)
                lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                al.lock.lock();//将会一直锁定，其他线程无法锁定
                System.out.println("acquired");
            }
        }.start();

        TimeUnit.SECONDS.sleep(1);//书中没有这句，将会执行失败

        Thread.yield();
        al.untimed();
        al.timed();


    }
}
