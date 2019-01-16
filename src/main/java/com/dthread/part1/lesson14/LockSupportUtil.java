package com.dthread.part1.lesson14;

import java.util.concurrent.locks.LockSupport;

/**
 * @author dongxiaohong
 * @date 2019/1/16 14:55
 */
public class LockSupportUtil {
    public static void main(String[] args) {
        new LockSupportUtil().exec();
    }

    public void exec(){
        Thread thread;
        (thread = new Thread(()->{
            //当前线程阻塞
            LockSupport.park();
            System.out.println(Thread.interrupted());
        })).start();
        /*new Thread(()->{
            //当前线程阻塞
            LockSupport.unpark(thread);
        }).start();*/
        System.out.println(thread.getState());
    }
}
