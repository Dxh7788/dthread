package com.dthread.part1.lesson3;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/4 15:42
 */
public class SafeTask implements Runnable {
    //16个线程局部变量
    private ThreadLocal<Date> dateThreadLocal1 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal2 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal3 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal4 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal5 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal6 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal7 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal8 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal9 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal10 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal11 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal12 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal13 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal14 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal15 = new ThreadLocal<Date>();
    private ThreadLocal<Date> dateThreadLocal16 = new ThreadLocal<Date>();
    @Override
    public void run() {
        dateThreadLocal1.set(new Date());
        dateThreadLocal2.set(new Date());
        dateThreadLocal3.set(new Date());
        dateThreadLocal4.set(new Date());
        dateThreadLocal5.set(new Date());
        dateThreadLocal6.set(new Date());
        dateThreadLocal7.set(new Date());
        dateThreadLocal8.set(new Date());
        dateThreadLocal9.set(new Date());
        dateThreadLocal10.set(new Date());
        dateThreadLocal11.set(new Date());
        dateThreadLocal12.set(new Date());
        dateThreadLocal13.set(new Date());
        dateThreadLocal14.set(new Date());
        dateThreadLocal15.set(new Date());
        dateThreadLocal16.set(new Date());
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
        System.out.printf("Thread Finished:%s : %s\n",Thread.currentThread().getId(), dateThreadLocal1.get());
    }
}
