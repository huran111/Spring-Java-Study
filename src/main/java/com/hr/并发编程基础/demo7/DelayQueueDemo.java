package com.hr.并发编程基础.demo7;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @ClassName DelayQueueDemo
 * @Date 2019/5/20 14:18
 * @Version 2.0
 */
public class DelayQueueDemo {
    static BlockingQueue<MyTask> tasks = new DelayQueue();
    static Random r = new Random();

    static class MyTask implements Delayed {
        long runningTime;

        MyTask(long rt) {
            this.runningTime = rt;
        }

        @Override
        public String toString() {
            return ""+runningTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else {
                return 0;
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now=System.currentTimeMillis();
        MyTask t1=new MyTask(now+1000);
        MyTask t2=new MyTask(now+1020);
        MyTask t3=new MyTask(now+1040);
        MyTask t4=new MyTask(now+1050);
        MyTask t5=new MyTask(now+1060);
        MyTask t6=new MyTask(now+1070);
        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);
        tasks.put(t6);
        System.out.println(tasks);
        System.out.println(tasks.size());
        for(int i=0;i<6;i++){
            System.out.println("===:"+tasks.take());
        }
        System.out.println(tasks.size());
    }
}
