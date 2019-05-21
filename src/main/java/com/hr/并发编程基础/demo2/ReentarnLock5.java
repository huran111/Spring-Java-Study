package com.hr.并发编程基础.demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther huran
 * @date
 **/
public class ReentarnLock5 extends Thread {
    private static Lock lock = new ReentrantLock(true);

    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ":获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentarnLock5 c1=new ReentarnLock5();
        Thread thread=new Thread(c1);
        thread.start();
        Thread thread1=new Thread(c1);
        thread1.start();
    }
}
