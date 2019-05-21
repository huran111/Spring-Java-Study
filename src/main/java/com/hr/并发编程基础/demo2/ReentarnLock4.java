package com.hr.并发编程基础.demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther huran
 * @date
 **/
public class ReentarnLock4 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1=new Thread(()->{
            try {
            lock.lock();
            System.out.println(" t1 start");
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t1.start();
        Thread t2=new Thread(()->{
            try {
                //lock.lock();
                lock.lockInterruptibly();
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t2.start();
        //打断线程T2的等待
        t2.interrupt();
    }
}
