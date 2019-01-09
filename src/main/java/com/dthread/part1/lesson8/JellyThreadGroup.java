package com.dthread.part1.lesson8;

import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohong
 * @date 2019/1/9 10:37
 */
public class JellyThreadGroup {
    /**
     * 线程组测试
     * */
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result =new Result();
        SearchTask searchTask = new SearchTask(result);
        for (int i=0;i<5;i++){
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("Number of Threads: %d\n",threadGroup.activeCount());
        System.out.println("Information about the Thread Group");
        threadGroup.list();
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i=0;i<threadGroup.activeCount();i++){
            System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
        }
        waitFinish(threadGroup);
        //使用interrupt()方法终端这个组件中的其余线程
        threadGroup.interrupt();
    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9){
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
