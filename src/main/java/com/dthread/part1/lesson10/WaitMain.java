package com.dthread.part1.lesson10;

/**
 * @author dongxiaohong
 * @date 2019/1/9 22:01
 */
public class WaitMain {

    private Object monitor = new Object();

    public static void main(String[] args) {
        final WaitMain waitMain =new WaitMain();
        //两个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                waitMain.waitMonitor();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                waitMain.wakeMonitor();
            }
        }).start();
    }

    public void waitMonitor(){
        synchronized (monitor){
            try {
                monitor.wait();
                System.out.println("lockMonitor立被刻唤醒!!!!!!");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void wakeMonitor(){
        synchronized (monitor){
            monitor.notifyAll();
        }
    }
}
