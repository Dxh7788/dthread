package com.dthread.part1.lesson3;

import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/4 15:49
 */
public class SafeMain {
    public static void main(String[] args) {
        SafeTask safeTask = new SafeTask();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(safeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
