package com.dthread.concurrenth;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author dongxiaohong
 * @date 2019/1/23 11:30
 */
public class ConcurrentHashMapMain {

    /**
     * 为key加入并发计数器
     * */
    public static void main(String[] args) {
        Map<String, LongAdder> map = new ConcurrentHashMap<>(12);
        Map<String, Integer> hashMap = new HashMap<>(12);
        //map.computeIfAbsent(key->new LongAdder()).increment();
        hashMap.put(null,5);
        System.out.println(hashMap.get(null));
    }
}
