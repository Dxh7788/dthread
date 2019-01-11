package com.dthread.part1.lesson13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongxiaohong
 * @date 2019/1/11 10:02
 */
public class JellyNonSync {
    Lock lock = new ReentrantLock(true);
    public static void main(String[] args) {
        final JellyNonSync jellyNonSync = new JellyNonSync();

        new Thread(new Runnable() {
            @Override
            public void run() {
                jellyNonSync.exec();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                jellyNonSync.exec();
            }
        }).start();
    }

    public synchronized void exec(){
        lock.lock();
        System.out.println(">>>>锁住....");
        lock.unlock();
    }
}
