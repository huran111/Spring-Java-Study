package com.hr.并发编程基础.demo7;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author 胡冉
 * @ClassName ConcurrentMapDemo
 * @Date 2019/5/20 11:10
 * @Version 2.0
 */
public class ConcurrentMapDemo {
    public static void main(String[] args) {
        Map<String,String> map=new ConcurrentHashMap<>(1);
        //高并发并且排序
//        Map<String,String> map= new ConcurrentSkipListMap<>();
//        Map<String,String>map=new Hashtable<>(1);
        Random r=new Random();
        Thread[] ths=new Thread[100];
        CountDownLatch countDownLatch=new CountDownLatch(ths.length);
        long start=System.currentTimeMillis();
        for(int i=0;i<ths.length;i++){
            ths[i]=new Thread(()->{
                for(int j=0;j<10000;j++){
                    map.put("a"+r.nextInt(100000),"a"+r.nextInt(100000));
                }
                countDownLatch.countDown();
            });
        }
        Arrays.asList(ths).forEach(t->t.start());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);

    }
}
