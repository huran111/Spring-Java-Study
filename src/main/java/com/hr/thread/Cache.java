package com.hr.thread;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2018:05
 * @copyright {@link www.hndfsj.com}
 */
public class Cache {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();
    static Lock r = rw1.readLock();
    static Lock w = rw1.writeLock();
    /**
     * 获取一个key对应的Value
     */
    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }
    /**
     * 设置key对应的value ,并返回旧的Value
     */
    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }

    }
    /**
     * 情况所有内容
     */
    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

}
