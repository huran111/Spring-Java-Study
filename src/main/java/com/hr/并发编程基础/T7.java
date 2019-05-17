package com.hr.并发编程基础;

import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @ClassName T7
 * @Date 2019/5/17 17:59
 * @Version 2.0
 */
public class T7 {
    /**
     * 程序执行过程中，如果出现异常，默认情况下，锁是会被释放的，
     * 如果处理异常不合理，其他线程进入同步代码区的时候，有可能访问到异常的数据
     */
    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + "start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (count == 5) {
                int i = 1 / 0;  //此处抛出异常，锁会释放， 若想不要释放锁，则捕获异常
            }


        }
    }

    public static void main(String[] args) {
        T7 t7 = new T7();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t7.m();
            }
        };
        new Thread(r, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "t2").start();

    }
}
