package com.hr.并发编程基础.demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther huran
 * @date
 **/
public class ReentarnLock2 {
    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

     void m2() {
        lock.lock();
        System.out.println("m2....");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentarnLock2 reentarnLock1 = new ReentarnLock2();
        new Thread(reentarnLock1::m1, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(reentarnLock1::m2, "t2").start();
    }
}
