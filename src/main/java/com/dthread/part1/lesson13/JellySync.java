package com.dthread.part1.lesson13;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

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
        JellySync jellySync = new JellySync();
        jellySync.acquire(1);
    }
}
