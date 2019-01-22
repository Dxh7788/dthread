package com.dthread.vol;

import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/22 10:41
 */
public class VolatileMain {

    public static void main(String[] args) {
        /**
         * 共享变量
        * */
        Firko firko = new Firko();

        /**
         * 两个线程来改变共享变量
         * */
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(firko.add());
        }).start();

        new Thread(()->{
            System.out.println(firko.add());
        }).start();
    }
}
