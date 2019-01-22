package com.dthread.vol;

/**
 * @author dongxiaohong
 * @date 2019/1/22 10:42
 */
public class Firko {
    private volatile int shareInt=0;

    public int add(){
        shareInt++;
        return shareInt;
    }
}
