package com.dthread.part1.lesson7;

/**
 * 扩展ThreadLocal
 * @author dongxiaohong
 * @date 2019/1/9 10:15
 */
public class JellyThreadLocal extends ThreadLocal {

    public static void main(String[] args) {
        //测试 InheritableThreadLocal用来继承使用
        InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set("test");
        System.out.println(inheritableThreadLocal.get());
        inheritableThreadLocal.remove();
    }
}
