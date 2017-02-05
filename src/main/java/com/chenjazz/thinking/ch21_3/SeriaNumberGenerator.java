package com.chenjazz.thinking.ch21_3;

/**
 * Jiazhi
 * 2016/4/13
 */
public class SeriaNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
