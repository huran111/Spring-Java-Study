package com.hr.并发编程基础.demo8;


import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @ClassName ExecutorService
 * @Date 2019/5/20 14:52
 * @Version 2.0
 */
public class ExecutorServiceDemo {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程名字:"+Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        service.shutdown();
//        service.shutdownNow();
//        System.out.println(service.awaitTermination(2, TimeUnit.SECONDS));
        System.out.println("isTerminated:" + service.isTerminated());
        System.out.println("isShutdown:" + service.isShutdown());
        System.out.println(service);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("isTerminated:" + service.isTerminated());
        System.out.println("isShutdown:" + service.isShutdown());
        System.out.println();
    }
}
