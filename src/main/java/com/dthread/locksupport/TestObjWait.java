package com.dthread.locksupport;
/**
 * @author dongxiaohong
 * */
public class TestObjWait {

    public static void main(String[] args)throws Exception {
        final Object obj = new Object();
        Thread A = new Thread(()-> {
            int sum = 0;
            for(int i=0;i<10;i++){
                sum+=i;
            }
            try {
                synchronized (obj){
                    obj.wait();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(sum);
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        //Thread.sleep(1000);
        /**
         * 有可能下面语句先执行,导致线程A阻塞
         * */
        synchronized (obj){
            obj.notify();
        }
    }
}