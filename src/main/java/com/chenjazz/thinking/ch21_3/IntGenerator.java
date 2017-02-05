package com.chenjazz.thinking.ch21_3;

/**
 * Jiazhi
 * 2016/4/12
 */
public abstract class IntGenerator {
    private volatile boolean canceled=false;
    public  abstract  int next();

    public  void canceled(){
        canceled=true;
    }

    public boolean isCanceled(){
        return canceled;

    }
}
