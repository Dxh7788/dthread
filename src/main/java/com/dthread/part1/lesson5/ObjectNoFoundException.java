package com.dthread.part1.lesson5;

/**
 * 运行时异常
 * 没有必要捕获
 * @author dongxiaohong
 * @date 2019/1/7 15:03
 */
public class ObjectNoFoundException extends RuntimeException {
    public ObjectNoFoundException(String message) {
        super(message);
    }
}
