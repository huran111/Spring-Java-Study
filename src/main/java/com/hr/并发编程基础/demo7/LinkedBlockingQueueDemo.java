package com.hr.并发编程基础.demo7;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @ClassName LinkedBlockingQueueDemo
 * @Date 2019/5/20 14:09
 * @Version 2.0
 */
public class LinkedBlockingQueueDemo {
    //阻塞队列
    static BlockingQueue<String>strs=new LinkedBlockingQueue<>();
    static Random r=new Random();
    public static void main(String[] args) {
        new Thread(()->{
            for(int i=0;i<100;i++){
                try {
                    strs.put("a"+i);
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"p1").start();
        for(int i=0;i<5;i++){
            new Thread(()->{
                for(;;){
                    try {
                        System.out.println(Thread.currentThread().getName() +" take --"+strs.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"c"+i).start();
        }
    }
}
