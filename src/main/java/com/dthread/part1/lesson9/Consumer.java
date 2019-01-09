package com.dthread.part1.lesson9;

/**
 * @author dongxiaohong
 * @date 2019/1/9 20:05
 */
public class Consumer extends Thread {
    private int num;
    private AbstractStorage abstractStorage;

    public void setNum(int num) {
        this.num = num;
    }

    public Consumer(AbstractStorage abstractStorage) {
        this.abstractStorage = abstractStorage;
    }

    @Override
    public void run() {
        consume(num);
    }

    public void consume(int num) {
        abstractStorage.consume(num);
    }
}
