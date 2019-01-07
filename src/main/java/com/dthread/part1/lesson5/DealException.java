package com.dthread.part1.lesson5;

/**
 * @author dongxiaohong
 * @date 2019/1/7 15:05
 */
public class DealException {

    public void dealUp() throws ObjectNotCheckedFoundException {
        throw new ObjectNotCheckedFoundException("非运行时异常");
    }

    public void dealDown(){
        throw new ObjectNoFoundException("运行时异常");
    }

    public static void main(String[] args) {
        DealException dealException = new DealException();
        try {
            dealException.dealUp();
        } catch (ObjectNotCheckedFoundException e) {
            System.out.println("能够捕获非运行时异常");
        }
        //dealException.dealDown();
        try {
            dealException.dealDown();
        }catch (Exception e){
            /**可以不用捕获,但是会中断程序,并在终端打印出来*/
            System.out.println("能够捕获运行时异常");
        }
    }
}
