package com.dthread.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author dongxiaohong
 * */
public class TestObjWaitLockSupport {

    public static void main(String[] args)throws Exception {
        final Object obj = new Object();
        Thread A = new Thread(()-> {
            int sum = 0;
            for(int i=0;i<10;i++){
                sum+=i;
            }
            LockSupport.park();
            System.out.println(sum);
        });
        A.start();
        LockSupport.unpark(A);
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        //Thread.sleep(1000);
        /**
         * 有可能下面语句先执行,导致线程A阻塞
         * */
    }
}