package com.dthread.part1.lesson9;

import java.util.LinkedList;

/**
 * @author dongxiaohong
 * @date 2019/1/9 19:57
 */
public class Storage implements AbstractStorage{
    private final int MAX_SIZE = 100;
    private LinkedList list = new LinkedList();

    /**生产产品*/
    @Override
    public void produce(int num){
        synchronized (list){
            while (list.size()+num > MAX_SIZE){
                System.out.println("[要生产的产品数量]：" + num +"\t[库存量]:" + list.size() +"\t暂时不能执行生产任务!");
                try {
                    list.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            for (int i=0;i<num;i++){
                list.add(new Object());
            }
            System.out.println("[已经生产产品数]:" + num + "\t[现仓储量为]:" + list.size());
            list.notifyAll();
        }
    }
    /**消费产品*/
    @Override
    public void consume(int num){
        synchronized (list){
            while (num > list.size()){
                System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:"  + list.size() + "\t暂时不能执行生产任务!");
                try {
                    /**释放锁*/
                    list.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            for (int i=0;i<num;i++){
                list.remove();
            }
            System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());
            list.notifyAll();
        }
    }
}
