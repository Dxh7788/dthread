package com.dthread.part1.lesson11;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author dongxiaohong
 * @date 2019/1/10 14:10
 */
public class TimerHolder {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("每60秒执行一次,不延时....");
            }
        },0,10*1000);
    }
}
