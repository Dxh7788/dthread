package com.dthread.part1.lesson3;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/4 15:23
 * 非线程安全
 */
public class UnsafeThread implements Runnable{
    /**
     * name是共享属性,为保证读取时的值为最新,
     * 使用volatile也不能保证数据是当前线程的内容
     * */
    private volatile Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        //System.out.printf("Starting Thread:%s:%s\n",Thread.currentThread().getId(),startDate);
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        /**
         * 其他线程改变了startDate的值,造成在此输出
         * 使得几个线程输出的startDate值相同
         * */
        System.out.printf("Thread Finished:%s : %s\n",Thread.currentThread().getId(),startDate);
    }
}
