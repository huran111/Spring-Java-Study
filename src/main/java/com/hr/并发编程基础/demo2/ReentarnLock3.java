package com.hr.并发编程基础.demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther huran
 * @date
 **/
public class ReentarnLock3 {
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
         boolean locked= false;
         try {
             locked = lock.tryLock(3, TimeUnit.SECONDS);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }finally {
             if(locked){
                 lock.unlock();
             }
         }
         System.out.println("m2...."+locked);


    }

    public static void main(String[] args) {
        ReentarnLock3 reentarnLock1 = new ReentarnLock3();
        new Thread(reentarnLock1::m1, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(reentarnLock1::m2, "t2").start();
    }
}
