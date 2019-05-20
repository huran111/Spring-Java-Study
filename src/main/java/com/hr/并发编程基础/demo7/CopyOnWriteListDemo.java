package com.hr.并发编程基础.demo7;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 胡冉
 * @ClassName CopyOnWriteListDemo
 * @Date 2019/5/20 13:52
 * @Version 2.0
 */
public class CopyOnWriteListDemo {
    public static void main(String[] args) {
        List<String> list=
                Collections.synchronizedList(new ArrayList<>());
//                new Vector<>();
//                new ArrayList<>();
//                new CopyOnWriteArrayList<>();
        Random r=new Random();
        Thread[] threads=new Thread[100];
        for(int i=0;i<threads.length;i++){
            Runnable task=new Runnable() {
                @Override
                public void run() {
                        for(int i=0;i<1000;i++){
                            list.add("a"+r.nextInt(10000));
                        }
                }
            };
            threads[i]=new Thread(task);
        }
        runAddComuterTime(threads);
        System.out.println(list.size());

    }

    private static void runAddComuterTime(Thread[] threads) {
        long s1=System.currentTimeMillis();
        Arrays.asList(threads).forEach(t->{
            t.start();
        });
        Arrays.asList(threads).forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2= System.currentTimeMillis();
        System.out.println(s2-s1);
    }
}
