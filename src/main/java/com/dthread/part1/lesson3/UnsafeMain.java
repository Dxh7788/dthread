package com.dthread.part1.lesson3;

import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/4 15:26
 */
public class UnsafeMain {

    public static void main(String[] args) {
        UnsafeThread unsafeThread = new UnsafeThread();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(unsafeThread);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
