package com.dthread.common;


/**
 * 此类主要用来分析Thread类源码
 * @author dongxiaohong
 * @date 2019/1/4 09:32
 */
public class TreadAnalyzer {

    /**analysis分析器*/
    public static void analysis(){
        /**
         * 创建Thread的方式---也就是Thread的构造函数
         * 按参数个数划分.
         * 1.无参数的
         * 2.带一个参数的
         *    2.1 name 名称 Thread(String name)
         *    2.2 target 线程 Thread(Runnable target)
         * 3.带两个参数的
         *    3.1 String name,Runnable target
         *    3.2 ThreadGroup threadGroup,String name
         *    3.3 ThreadGroup threadGroup,Runnable target
         * 4.带三个参数的
         *    4.1 String name,ThreadGroup threadGroup,Runnable target
         * 5.带四个参数的
         *    5.1 ThreadGroup group, Runnable target, String name,long stackSize
         * */
        /**无参数和1个参数*/
        Thread thread;
        /**
         * 空线程没有意义,因为它什么都不会做
         * */
        thread = new Thread();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inner Thread");
            }
        });
        thread = new Thread("Thread-name-0");
        /**2个参数*/
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inner Thread");
            }
        },"thread-a-0");
        thread = new Thread(new ThreadGroup("group1"),"t-group1-runnable1");
        thread = new Thread(new ThreadGroup("group2"), new Runnable() {
            @Override
            public void run() {
                System.out.println("group-runnable");
            }
        });
        thread = new Thread(new ThreadGroup("group3"), new Runnable() {
            @Override
            public void run() {
                System.out.println("group3-runnable");
            }
        },"t-group3-runnable3");
        thread = new Thread(new ThreadGroup("group4"), new Runnable() {
            @Override
            public void run() {
                System.out.println("group4-runnable");
            }
        },"t-group4-runnable",5);
        /**
         * 构造函数最后都要调用
         * private void init(ThreadGroup g, Runnable target, Runnable target,long stackSize, AccessControlContext acc,boolean inheritThreadLocals)
         * 这是一个私有方法,却是一个核心方法
         * @ThreadGroup g 所属线程组
         * @Runnable target 线程
         * @Runnable target 线程名称,默认是构造时的顺序数加上前缀thread-
         * @long stackSize 栈大小,线程栈大小
         * @AccessControlContext acc 权限控制上下文acc,不会由程序员自定义.程序默认初始化
         * @boolean inheritThreadLocals 是否继承ThreadLocal,默认为true，除了Thread(Runnable target, AccessControlContext acc)时会为false外,其他情况下都为true
         * */
    }

    /**dealer*/
    public static void dealer(){
        /**
         * 空线程没有意义,因为它什么都不会做
         * */
        Thread thread = new Thread();
        System.out.println(thread.getThreadGroup().getName());
        System.out.println(Thread.activeCount());
        thread.start();
    }
    /**doer*/
    public static void doer() throws InterruptedException {
        /**
         * 空线程没有意义,因为它什么都不会做
         * */
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("01");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread.start();
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("02");
            }
        });
        thread2.start();
    }
    /**
     * 执行函数
     * */

    public static void main(String[] args) throws InterruptedException {
        doer();
        //dealer();
        //analysis();
    }
}
