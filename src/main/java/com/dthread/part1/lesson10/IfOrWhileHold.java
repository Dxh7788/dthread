package com.dthread.part1.lesson10;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author dongxiaohong
 * @date 2019/1/10 09:23
 */
public class IfOrWhileHold {

    private String key = "";
    private boolean goOn = true;
    private boolean pause = true;
    public static void main(String[] args) {
        final IfOrWhileHold waitHold = new IfOrWhileHold();
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
        while /*if*/(pause) {
            System.out.println(">>>>>>请输入......");
            InputStream inputStream = System.in;
            Scanner scanner = new Scanner(inputStream);
            key = scanner.nextLine();
            goOn = true;
            this.notifyAll();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void goOning(){
        while /*if*/(goOn) {
            System.out.println(">>>>>>您输入了" + key);
            pause = true;
            this.notifyAll();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
