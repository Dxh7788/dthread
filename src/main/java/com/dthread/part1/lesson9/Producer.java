package com.dthread.part1.lesson9;

/**
 * @author dongxiaohong
 * @date 2019/1/9 20:05
 */
public class Producer extends Thread {
    private int num;
    private AbstractStorage abstractStorage;

    public void setNum(int num) {
        this.num = num;
    }

    public Producer(AbstractStorage abstractStorage) {
        this.abstractStorage = abstractStorage;
    }

    @Override
    public void run() {
        produce(num);
    }

    public void produce(int num) {
        abstractStorage.produce(num);
    }
}
