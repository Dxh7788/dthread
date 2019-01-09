package com.dthread.part1.lesson8;


/**
 * @author dongxiaohong
 * @date 2019/1/9 11:34
 */
public class Main {
    public static void main(String[] args) {
        JellyThreadFactory factory = new JellyThreadFactory();
        Thread thread = factory.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(">>>>工厂创建线程....");
            }
        });
        thread.start();
        JellyThreadFactory.createThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(">>>>静态静态方法创建....");
            }
        }).start();
    }
}
