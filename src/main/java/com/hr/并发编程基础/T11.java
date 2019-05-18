package com.hr.并发编程基础;

import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @ClassName T11
 * @Date 2019/5/18 13:49
 * @Version 2.0
 */
public class T11 {
    /**
     * 锁在堆内存的对象上
     */
    Object o=new Object();
    void m()   {
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        T11 t11=new T11();
        new Thread(t11::m,"t1").start();
        TimeUnit.SECONDS.sleep(3);
        new Thread(t11::m,"t2").start();
        t11.o=new Object();
    }
}
