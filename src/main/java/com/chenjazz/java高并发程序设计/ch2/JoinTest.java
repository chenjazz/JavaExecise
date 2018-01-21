package com.chenjazz.java高并发程序设计.ch2;

import org.junit.Test;

public class JoinTest {
    volatile static int i = 0;

    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int j = 1; j <= 100; j++) {
                i = i + j;
            }
        });
        thread.start();

        thread.join();//这里main线程会停下来等待thread线程执行完
        System.out.println(i);//输出5050
    }
}
