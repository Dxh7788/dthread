package com.dthread.part1.lesson11;

import java.util.Calendar;
import java.util.Date;

/**
 * @author dongxiaohong
 * @date 2019/1/10 11:28
 */
public class TimerHold {

    public static void main(String[] args) {
        final TimerHold hold = new TimerHold();
        Thread thread;
        Thread thread2;
        (thread = new Thread(new Runnable() {
            @Override
            public void run() {
                hold.execAtTime();
            }
        })).start();
        (thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                hold.notifyAtTime();
            }
        })).start();
    }

    public void execAtTime() {
        while (true){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());

            while (calendar.get(Calendar.MINUTE) != 54){
                synchronized (this){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(">>>>>>定时执行....");
            break;
        }
    }
    public void notifyAtTime() {
        while (true){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());

            System.out.println(calendar.get(Calendar.MINUTE));
            System.out.println(calendar.get(Calendar.MINUTE) == 54);
            if (calendar.get(Calendar.MINUTE) == 54){
                synchronized (this){
                    this.notifyAll();
                    break;
                }
            }
        }
    }
}
