package com.dthread.part1.lesson5;

/**
 * @author dongxiaohong
 * @date 2019/1/7 15:20
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("An exception has been Captured");
        System.out.printf("Thread:%s\n",t.getId());
        System.out.printf("Exception:%s:%s\n",e.getClass().getName(),e.getMessage());
    }
}
