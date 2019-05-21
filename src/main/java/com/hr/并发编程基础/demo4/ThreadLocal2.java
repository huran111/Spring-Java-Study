package com.hr.并发编程基础.demo4;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;

/**
 * @auther huran
 * @date
 **/
public class ThreadLocal2 {
static ThreadLocal<Person2> threadLocal=new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());

        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            threadLocal.set(new Person2());

        }).start();
    }
}

class Person2 {
    String name = "huran";
}