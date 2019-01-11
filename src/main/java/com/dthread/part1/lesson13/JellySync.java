package com.dthread.part1.lesson13;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongxiaohong
 * @date 2019/1/11 10:02
 */
public class JellySync extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        return false;
    }

    public static void main(String[] args) {
        new JellySync().exec();
    }

    public synchronized void exec(){
        Lock lock = new ReentrantLock();
        lock.lock();
        System.out.println(">>>>锁住....");
        lock.unlock();
    }
}
