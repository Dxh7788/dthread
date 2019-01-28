package com.dthread.concurrenth;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author dongxiaohong
 * @date 2019/1/23 14:44
 */
public class CounterTask extends RecursiveTask<Integer> {
    public static final int threshold = 2;
    private int start;
    private int end;

    public CounterTask(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end-start)<=threshold;
        if (canCompute){
            for (int i=start;i<=end;i++){
                sum+=i;
            }
        }else {
            int middle = (start+end)/2;
            CounterTask leftTask = new CounterTask(start,middle);
            CounterTask rightTask = new CounterTask(middle+1,end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并子任务
            sum = leftResult+rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CounterTask task = new CounterTask(1, 100);
        Future<Integer> result = pool.submit(task);
        try {
            System.out.println(result.get());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
