package com.dthread.part1.lesson8;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/9 10:47
 */
public class SearchTask implements Runnable {
    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s:Start \n",name);
        try {
            doTask();
            result.setName(name);
        }catch (InterruptedException e){
            System.out.printf("Thread %s:Interrupted\n",name);
            return;
        }
        System.out.printf("Thread %s: End\n",name);
    }

    private void doTask() throws InterruptedException {
        Random random = new Random(System.currentTimeMillis());
        int value = (int)(random.nextDouble()*100);
        System.out.printf("Thread %s: %d\n",Thread.currentThread().getName(),value);
        TimeUnit.SECONDS.sleep(value);
    }
}
