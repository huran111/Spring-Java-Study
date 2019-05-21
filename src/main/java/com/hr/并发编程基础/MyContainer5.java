package com.hr.并发编程基础;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @ClassName MyContainer1
 * @Date 2019/5/18 14:05
 * @Version 2.0
 */

/**
 * 闭锁 门栓
 */
public class MyContainer5 {
    volatile List list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(1);
        MyContainer5 myContainer1 = new MyContainer5();
        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2先启动");
                if (myContainer1.size() != 5) {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束");
                lock.notify();
            }
        }, "t2").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    myContainer1.add(new Object());
                    System.out.println("add:" + i);
                    if (myContainer1.size() == 5) {
                        countDownLatch.countDown();
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();


    }
}
