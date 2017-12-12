package com.chenjazz.Java并发编程的艺术.第4章;

import java.util.concurrent.TimeUnit;

/**
 * @author chenjazz 17-12-11
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domina(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        TimeUnit.SECONDS.sleep(3);

        System.out.println(Thread.currentThread().getName() + "---- terminate.");

    }

    static class Domina implements Runnable {
        private Thread thread;

        public Domina(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "terminate.");
        }
    }
}
