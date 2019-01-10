package com.dthread.part1.lesson12;

/**
 * @author dongxiaohong
 * @date 2019/1/10 15:15
 */
public class Main {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i=0;i<10;i++){
            threads[i] = new Thread(new Job(printQueue),"Thread "+i);
            threads[i].start();
        }
    }
}
