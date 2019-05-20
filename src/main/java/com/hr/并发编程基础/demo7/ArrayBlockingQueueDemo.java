package com.hr.并发编程基础.demo7;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @ClassName ArrayBlockingQueueDemo
 * @Description: TODO
 * @Date 2019/5/20 14:13
 * @Version 2.0
 */
public class ArrayBlockingQueueDemo {
    static BlockingQueue<String>strs=new ArrayBlockingQueue<String>(10);
    static Random r=new Random();

    public static void main(String[] args) throws InterruptedException {
            for(int i=0;i<10;i++){
                try {
                    strs.put("a"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println(strs.offer("aa"));
        // put 满了阻塞
        strs.put("111");
        try {
            strs.offer("huran",1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(strs);
    }
}
