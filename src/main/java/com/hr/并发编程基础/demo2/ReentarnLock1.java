package com.hr.并发编程基础.demo2;

import java.util.concurrent.TimeUnit;

/**
 * @auther huran
 * @date
 **/

/**
 * 可以替代 synchronized
 */
public class ReentarnLock1 {
    synchronized void m1(){
        for(int i=0;i<10;i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
    synchronized void m2(){
        System.out.println("m2....");
    }

    public static void main(String[] args) {
        ReentarnLock1 reentarnLock1=new ReentarnLock1();
        new Thread(reentarnLock1::m1,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(reentarnLock1::m2,"t2").start();
    }
}
