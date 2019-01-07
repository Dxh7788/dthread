package com.dthread.part1.lesson4;

import java.lang.ref.WeakReference;

/**
 * @author dongxiaohong
 * @date 2019/1/4 16:45
 */
public class JellyThreadLocalMap {

    class Entry extends WeakReference<JellyThreadLocal<?>>{
        Object value;
        public Entry(JellyThreadLocal k,Object v) {
            super(k);
            value = v;
        }
    }
    private static final int INITIAL_CAPACITY = 16;
    private Entry[] table;
    private int size = 0;
    private int threshold; // Default to 0

    public JellyThreadLocalMap(ThreadLocal<?> firstKey,Object firstValue) {
        table = new Entry[INITIAL_CAPACITY];
    }
}
