package com.chenjazz.java高并发程序设计.ch2;

import org.junit.Test;

/**
 * 2.2.3
 */
public class InterruptedTest {


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "线程被中断");
                    break;
                }
                System.out.println("hello world");
            }
        }, "t1");
        thread.start();

        Thread.sleep(2000);

        System.out.println(thread.getName() + "当前中断状态:" + thread.isInterrupted());
        thread.interrupt();
    }


    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("线程被中断：" + e.getMessage());
            }
        });
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();
     }
}
