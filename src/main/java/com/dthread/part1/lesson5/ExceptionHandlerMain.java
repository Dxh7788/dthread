package com.dthread.part1.lesson5;

/**
 * @author dongxiaohong
 * @date 2019/1/7 15:23
 */
public class ExceptionHandlerMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer a = Integer.parseInt("TTT");
            }
        });
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}