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

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer a = Integer.parseInt("TTT");
                }catch (Exception e){
                    System.out.println("捕获异常");
                }
            }
        });
        thread.start();
        thread1.start();
    }
}