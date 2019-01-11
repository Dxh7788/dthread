package com.dthread.part1.lesson14;

/**
 * @author dongxiaohong
 * @date 2019/1/11 11:45
 */
public class InterruptMain {

    /**
     *
     * */
    public static void main(String[] args) {
        int n=0;
        while (n<100) {
            Thread thread;
            System.out.println("------------------start--------------");
            (thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().interrupt();
                    System.out.println("中断后重新执行");
                }
            })).start();

            if (thread.isInterrupted()) {
                System.out.println("中断成功");
            }
            System.out.println("------------------end--------------");
            n++;
        }
    }
}
