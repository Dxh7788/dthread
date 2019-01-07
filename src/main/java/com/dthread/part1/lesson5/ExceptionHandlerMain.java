package com.dthread.part1.lesson5;

/**
 * @author dongxiaohong
 * @date 2019/1/7 15:23
 */
public class ExceptionHandlerMain {
    public static void main(String[] args) {
        //线程的默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer a = Integer.parseInt("TTT");
            }
        });
        thread.setUncaughtExceptionHandler(new ExceptionHandler());

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer a = Integer.parseInt("TTT");
            }
        });
        thread.start();
        thread1.start();
    }
}