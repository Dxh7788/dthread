package com.dthread.part1.lesson13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongxiaohong
 * @date 2019/1/11 10:02
 */
public class JellyNonSync {
    public static void main(String[] args) {
        final JellyNonSync jellyNonSync = new JellyNonSync();
        final Lock lock = new ReentrantLock(false);
        Thread[] threads = new Thread[10];
        for (int i=0;i<10;i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    Thread.currentThread().interrupt();
                    System.out.println(">>>>锁住....");
                    lock.unlock();
                }
            });
        }

        for (int i=0;i<10;i++) {
            threads[i].start();
        }
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                jellyNonSync.exec();
            }
        }).start();*/
    }

    /*public synchronized void exec(){
        lock.lock();
        System.out.println(">>>>锁住....");
        lock.unlock();
    }*/
}
