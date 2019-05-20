package com.hr.并发编程基础.demo7;

import com.hr.currentthread.lock.Queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author 胡冉
 * @ClassName ConcurrentQueue
 * @Date 2019/5/20 14:02
 * @Version 2.0
 */
public class ConcurrentQueue {
    public static void main(String[] args) {
        //无界队列
        ConcurrentLinkedQueue queue=  new ConcurrentLinkedQueue<String>();
        for(int i=0;i<10;i++){
            queue.offer("a"+i);
        }
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.size());

    }
}
