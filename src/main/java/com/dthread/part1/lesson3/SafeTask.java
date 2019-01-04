package com.dthread.part1.lesson3;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/4 15:42
 */
public class SafeTask implements Runnable {
    private ThreadLocal<Date> dateThreadLocal = new ThreadLocal<Date>();
    @Override
    public void run() {
        dateThreadLocal.set(new Date());
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
        System.out.printf("Thread Finished:%s : %s\n",Thread.currentThread().getId(),dateThreadLocal.get());
    }
}
