package com.dthread.part1.lesson2;

import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/4 14:23
 */
public class Main {

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        task.interrupt();
    }
}
