package com.dthread.part1.lesson10;

/**
 * @author dongxiaohong
 * @date 2019/1/10 09:23
 */
public class WaitHold {

    public static void main(String[] args) {
        final WaitHold waitHold = new WaitHold();
        /**
         * 使用如下方式是不行的,虽然不报错.但是无法起到预期效果
         * <pre>waitHold.pause();<pre/>
         * <pre>waitHold.goOning();<pre/>
         * 必须使用两个线程来处理,方式如下:
         *
         * */
        Thread pauseThread = new Thread(new Runnable() {
            @Override
            public void run() {
                waitHold.pause();
            }
        });
        Thread goOningThread = new Thread(new Runnable() {
            @Override
            public void run() {
                waitHold.goOning();
            }
        });
        pauseThread.start();
        goOningThread.start();
    }

    /**
     * synchronized用在方法上,使用的监控器是this.所以每次只能执行一个同步方法.
     * */
    public synchronized void pause(){
        System.out.println(">>>>>>暂时交出锁并退出......");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>>>>>重新获取锁并执行完成......");
    }

    public synchronized void goOning(){
        System.out.println(">>>>>>告知可以重新获取锁......");
        this.notifyAll();
    }
}
