package com.dthread.part1.lesson2;


import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/4 14:38
 */
public class TimeUnitMain {

    public static void main(String[] args) {
        long duration = System.currentTimeMillis();
        System.out.println(TimeUnit.MILLISECONDS.toDays(duration)+"日"
                +TimeUnit.MILLISECONDS.toHours(duration)+"点"
                +TimeUnit.MILLISECONDS.toMinutes(duration)+"分"
                +TimeUnit.MILLISECONDS.toSeconds(duration)+"秒");
    }
}
