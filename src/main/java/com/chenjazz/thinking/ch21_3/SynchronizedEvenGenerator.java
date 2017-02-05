package com.chenjazz.thinking.ch21_3;

/**
 * Jiazhi
 * 2016/4/12
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;


    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {

        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
