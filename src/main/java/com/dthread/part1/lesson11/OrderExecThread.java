package com.dthread.part1.lesson11;

import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/10 10:34
 */
public class OrderExecThread {

    public static void main(String[] args) {
        final OrderExecThread orderExecThread = new OrderExecThread();
        final Object lock0 = new Object();
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1先执行完成...");
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                /**首先等待*/
                orderExecThread.lock(lock0);
                System.out.println("线程2执行完成");
            }
        });
        thread0.start();
        thread1.start();
        while (true) {
            System.out.println(thread0.getState());
            if (Thread.State.TERMINATED.equals(thread0.getState())) {
                orderExecThread.release(lock0);
                break;
            }
        }
        while (true){
            System.out.println(thread1.getState());
            if (thread1.getState().equals(Thread.State.WAITING)){
                try {
                    System.out.println(thread1.getState());
                    //主进程让出cpu
                    synchronized (TimeUnit.SECONDS) {
                        TimeUnit.SECONDS.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Thread.State.TERMINATED.equals(thread1.getState())){
                break;
            }
        }
    }
    public void lock(Object lock){
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void release(Object lock){
        synchronized (lock){
            lock.notifyAll();
        }
    }
}
