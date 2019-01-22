package com.dthread.vol;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongxiaohong
 * @date 2019/1/22 11:44
 */
public class Counter {
    private AtomicInteger atomicI = new AtomicInteger(0);
    private AtomicInteger atomicII = new AtomicInteger(0);
    private int i =0;
    public static void main(String[] args) {
        final Counter cas =new Counter();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0;j<100;j++){
            Thread t = new Thread(()-> {
                for (int i=0;i<1000;i++){
                    cas.count();
                    cas.safeCount();
                    cas.autoUnsafeCount();
                }
            });
            ts.add(t);
        }
        for (Thread tss:ts){
            tss.start();
        }
        /**
         * 等待所有线程执行结束
         * */
        for (Thread tsss:ts){
            try {
                tsss.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(cas.atomicII.get());
        System.out.println(System.currentTimeMillis()-start);
    }

    /**
     * 使用CAS实现线程安全计数器
     * */
    private void safeCount() {
        for (;;){
            int i=atomicI.get();
            boolean suc = atomicI.compareAndSet(i,++i);
            if (suc){
                break;
            }
        }
    }
    /**
     * 非线程安全计数器
     * */
    private void count() {
        i++;
    }

    /**
     * AtomicInteger的非线程安全计数器
     * */
    private void autoUnsafeCount(){
        int i = atomicII.get();
        atomicII.compareAndSet(i,++i);
    }
}
