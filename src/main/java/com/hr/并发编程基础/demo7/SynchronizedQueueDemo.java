package com.hr.并发编程基础.demo7;

import org.springframework.aop.ThrowsAdvice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author 胡冉
 * @ClassName SynchronizedQueueDemo
 * @Description: TODO
 * @Date 2019/5/20 14:39
 * @Version 2.0
 */
public class SynchronizedQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //容量为0 的队列
        BlockingQueue<String> strs=new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //等待消费者消费
        strs.put("aa");
        System.out.println(strs.size());
    }



}
