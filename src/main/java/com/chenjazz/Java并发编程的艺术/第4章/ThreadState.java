package com.chenjazz.Java并发编程的艺术.第4章;

import java.util.concurrent.TimeUnit;

/**
 * 线程的状态
 * NEW            没有调用start()
 * RUNNABLE       就绪和运行
 * BLOCKED        线程阻塞于锁
 * WAITING
 * TIME_WAITING
 * TERMINATED
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitTh").start();
        new Thread(new Waiting(), "WaitingTh").start();

        new Thread(new Blocked(), "blocked-1-Th").start();
        new Thread(new Blocked(), "blocked-2-Th").start();
    }

    //不断睡眠
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //waiting.class上等待
    static class Waiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


    static class Blocked implements Runnable {

        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
