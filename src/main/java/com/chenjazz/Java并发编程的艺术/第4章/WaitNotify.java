package com.chenjazz.Java并发编程的艺术.第4章;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static com.chenjazz.PrintUtils.println;

public class WaitNotify {

    static boolean flag = true;

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Wait(), "W-Th").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(new Notify(), "Not-Th").start();

    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            //加锁
            synchronized (lock) {
                while (flag) {
                    try {
                        println("{} flag is true. wait @ {}", Thread.currentThread().toString(), LocalDateTime.now());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //finish
                println("{} flag is false. running @ {}", Thread.currentThread().toString(), LocalDateTime.now());

            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                println("{} hold lock . notify @ {}", Thread.currentThread().toString(), LocalDateTime.now());
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //再次加锁
            synchronized (lock){
                println("{} hold lock again . sleep @ {}", Thread.currentThread().toString(), LocalDateTime.now());

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
