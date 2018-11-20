package com.hr.currentthread.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author huran
 * @Title: Test2
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2415:22
 */
public class Test2 {
        static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){

                    System.out.println(Thread.currentThread().getName()+":子线程正在执行:"+i);
                }
                countDownLatch.countDown();
            }
        });

        thread.start();
        for(int i=0;i<50;i++){

            System.out.println(Thread.currentThread().getName()+":主线程正在执行");
        }
        countDownLatch.await();
        System.out.println("全部执行完毕");
    }


}
