package com.dthread.part1.lesson6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongxiaohong
 * @date 2019/1/7 19:06
 */
public class ThreadLocalMapFake {

    private final int threadLocalHashCode = nextHashCode();

    private static AtomicInteger nextHashCode = new AtomicInteger();

    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode(){
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }
    public static void main(String[] args) {
        ThreadLocalMapFake mapFake = new ThreadLocalMapFake();
        System.out.println(mapFake.threadLocalHashCode);
        ThreadLocalMapFake mapFake1 = new ThreadLocalMapFake();
        System.out.println(mapFake1.threadLocalHashCode);
        ThreadLocalMapFake mapFake2 = new ThreadLocalMapFake();
        System.out.println(mapFake2.threadLocalHashCode);
    }
}
