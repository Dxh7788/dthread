package com.dthread.part1.lesson8.synchronize;

/**
 * @author dongxiaohong
 * @date 2019/1/9 14:06
 */
public class RunTask {

    private static int anInt = 0;

    public static void setAndAdd(){
        anInt +=1;
        System.out.println(anInt);
    }

    public synchronized static void getAndSet(){
        anInt +=1;
        System.out.println(anInt);
    }
    public synchronized static void setAndGet(){
        anInt +=1;
        System.out.println(anInt);
    }
    //非静态非synchronized方法
    public void setAnInt(){
        anInt +=1;
        System.out.println(anInt);
    }

    public synchronized void snInt(){
        anInt +=1;
        System.out.println(anInt);
    }

    public synchronized void ssnInt(){
        anInt +=1;
        System.out.println(anInt);
    }
}
