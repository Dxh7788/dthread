package com.dthread.part1.lesson8;

import java.util.concurrent.ThreadFactory;

/**
 * @author dongxiaohong
 * @date 2019/1/9 11:27
 */
public class JellyThreadFactory implements ThreadFactory {
    private static JellyThreadFactory factory = new JellyThreadFactory();
    public static Thread createThread(Runnable target){
        return factory.newThread(target);
    }
    @Override
    public  Thread newThread(Runnable target) {
        return new Thread(target);
    }
}
