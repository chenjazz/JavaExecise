package com.chenjazz.java编程思想.ch21_3;

/**
 * Jiazhi
 * 2016/4/12
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;


    @Override
    public int next() {
        ++currentEvenValue;
        Thread.yield();//增加失败的可能性
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {

        EvenChecker.test(new EvenGenerator());
    }
}
