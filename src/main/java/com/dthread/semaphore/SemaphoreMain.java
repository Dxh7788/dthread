package com.dthread.semaphore;

/**
 * @author dongxiaohong
 * @date 2019/1/17 11:12
 */
public class SemaphoreMain {

    public static void main(String[] args) {

        new Thread(()->{
            Thread.currentThread().interrupt();
            System.out.println("####中断线程执行....");
        }).start();
        new TaC(()->{
            System.out.println("dsfs");
        }).run();

    }
}

interface Ta{
    /**
     * 重写方法run
    * */
    void run();
}

class TaC{
    private Ta ta;
    public TaC(Ta ta){
        this.ta = ta;
    }
    public void run(){
        ta.run();
    }
}
