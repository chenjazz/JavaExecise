package com.chenjazz.thinking.ch21_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Jiazhi
 * 2016/4/12
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {

        EvenChecker.test(new MutexEvenGenerator());
    }
}
