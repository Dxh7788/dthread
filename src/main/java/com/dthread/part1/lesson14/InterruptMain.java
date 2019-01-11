package com.dthread.part1.lesson14;

import java.util.Scanner;

/**
 * @author dongxiaohong
 * @date 2019/1/11 11:45
 */
public class InterruptMain {

    int num = 0;
    /**
     *
     * */
    public static void main(String[] args) {
        int n=0;
        while (n<100) {
            Thread thread;
            System.out.println("------------------start--------------");
            (thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().interrupt();
                    System.out.println("中断后重新执行");
                }
            })).start();

            if (thread.isInterrupted()) {
                System.out.println("中断成功");
            }
            System.out.println("------------------end--------------");
            n++;
        }
        System.out.println(new InterruptMain().acquireAcc());
    }

    public Boolean acquireAcc(){
        boolean failed = true;
        try {
            boolean interrupted = false;
            for (;;){
                Scanner scanner = new Scanner(System.in);
                num = scanner.nextInt();
                if (num == 0){
                    return interrupted;
                }
                Scanner scanner2 = new Scanner(System.in);
                num = scanner2.nextInt();
                if (num == 9 ) {
                    interrupted = true;
                }
            }
        }finally {
            if (failed){

            }
        }
    }
}
