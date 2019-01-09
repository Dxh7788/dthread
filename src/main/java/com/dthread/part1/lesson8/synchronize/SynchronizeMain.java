package com.dthread.part1.lesson8.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 对象锁和类锁
 * 对象锁:对象锁锁住的是this,同一时间同一对象的非静态同步方法只能有一个获取到锁并执行。
 * 类锁:类锁锁住的是整个class文件,同一时间只有一个对象能获取到锁并执行.是一个全局锁。
 * 对象锁不能限制同一个对象,不同对象能执行相同的synchronized方法不受通不影响。
 * @author dongxiaohong
 * @date 2019/1/9 14:04
 */
public class SynchronizeMain {
    public static void main(String[] args) {
        final RunTask runTask = new RunTask();
        /**
         * 1.两个线程并发访问非synchronized静态方法,导致数据异常。
         * */
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                RunTask.setAndAdd();
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                RunTask.setAndAdd();
            }
        });
//        thread0.start();
//        thread1.start();
        System.out.println("两个线程并发访问synchronized静态方法,getAndSet是synchronized方法.....开始");
        /**
         * 2.两个线程并发访问synchronized静态方法,getAndSet是synchronized方法
         * 数据不会出现异常。synchronized锁定临界区，只有执行完后才能执行另一个
         * */
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                RunTask.getAndSet();
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                RunTask.getAndSet();
            }
        });
//        thread3.start();
//        thread4.start();
        System.out.println("两个线程并发访问一个synchronized静态方法和非synchronized的实例方法.....开始");
        /**
         * 两个线程并发访问一个synchronized静态方法和非synchronized的实例方法,会造成数据异常
         * */
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                runTask.setAnInt();
            }
        });

        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                RunTask.getAndSet();
            }
        });
//        thread5.start();
//        thread6.start();
        /**
        * 两个线程能同时访问一个类中2个不同的synchronized static方法吗
         * synchronized锁住的是整个类对象即RunTask.class所以只能调用一个static方法.
        * */
        Thread thread7 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                RunTask.setAndGet();
            }
        });

        Thread thread8 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                RunTask.getAndSet();
            }
        });
//        thread7.start();
//        thread8.start();
        /**
         * 同一对象不同synchronized的线程争用
         * */
        Thread thread9 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                runTask.snInt();
            }
        });

        Thread thread10 = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                runTask.ssnInt();
            }
        });
        thread9.start();
        thread10.start();
    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
