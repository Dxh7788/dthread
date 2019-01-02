package com.dthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongxiaohong
 * @date 2019/1/2 09:37
 */
public class Trehred {
    /**使用volatile刷新值*/
    private volatile int sfk = 2000;
    /**使用volatile刷新值*/
    private volatile int sfk2 = 2000;
    /**写的锁*/
    private Object writeObject = new Object();
    /**
     * 使用synchronized同步保持原子性
     * 读写一起被锁定,此时不需要使用volatile
     * 使用synchronized的话,只有在程序线程运行完或者异常时,JVM才能释放锁.如果程序中有IO等待或者其他线程等待的问题.则其他线程就需要长久的等待下去
     *
     * */
    public synchronized void add(){
        sfk++;
        System.out.println(sfk);
    }
    /**
     * sfk的读操作不加锁,写加锁,然后使用不带volatile的变量
     * */
    public void lockWrite(){
        int a = sfk2;
        /**写加锁*/
        synchronized (writeObject){
            sfk2 = sfk2+1;
        }
        System.out.println(a);
    }
    /**
     * 使用锁的方式
     * */
    public synchronized void addLock(){
        Lock lock = new ReentrantLock();
        lock.lock();
        sfk++;
        System.out.println(sfk);
        lock.unlock();
    }
}
