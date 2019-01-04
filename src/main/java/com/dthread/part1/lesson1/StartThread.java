package com.dthread.part1.lesson1;

/**
 * @author dongxiaohong
 * @date 2019/1/3 09:51
 * 线程创建的两种方式,一个是实现
 * @see java.lang.Runnable 接口,
 * 一个是实现
 * @see java.lang.Thread ,以下的两种具体的方式
 */
public class StartThread {

    public static void main(String[] args) {
        Thread thread0 = new Thread(new StartRunnableThread());
        Thread thread1 = new Thread(new StartSubThread());
        thread0.start();
        thread1.start();
        /**线程信息的获取和设置*/
        System.out.println("线程id:"+thread0.getId()+
                ",名称:"+thread0.getName()+",优先级:"+
                thread0.getPriority()+",运行状态:"+
                thread0.getState().name());
        System.out.println("线程id:"+thread1.getId()+
                ",名称:"+thread1.getName()+
                ",优先级:"+thread1.getPriority()+
                ",运行状态:"+thread1.getState().name());
        /**main线程*/
        System.out.println(Thread.currentThread().getName());
        /**线程的中断*/

    }
}
/**接口方式*/
class StartRunnableThread implements Runnable{
    /**实现run方法*/
    @Override
    public void run() {
        System.out.println("线程id:"+Thread.currentThread().getId()+
                ",名称:"+Thread.currentThread().getName()+",优先级:"+
                Thread.currentThread().getPriority()+",运行状态:"+
                Thread.currentThread().getState().name());
        System.out.println(">>>>Runnable 方式的线程运行开始....");
    }
}
/**类的方式,继承Thread并覆盖run方法*/
class StartSubThread extends Thread{
    @Override
    public void run() {
        System.out.println("线程id:"+Thread.currentThread().getId()+
                ",名称:"+Thread.currentThread().getName()+",优先级:"+
                Thread.currentThread().getPriority()+",运行状态:"+
                Thread.currentThread().getState().name());
        System.out.println(">>>>Thread 方式的线程运行开始....");
    }
}
/**其实说到底还是一种方式,那就是实现Runnable接口,因为Thread类是Runnable的默认实现方式*/