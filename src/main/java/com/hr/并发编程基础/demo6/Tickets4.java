package com.hr.并发编程基础.demo6;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author 胡冉
 * @ClassName Tickets4
 * @Date 2019/5/20 9:30
 * @Version 2.0
 */
public class Tickets4 {
    static Queue<String> tickets = new ConcurrentLinkedQueue();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票号：" + i);
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                while (true){
                    //CAS
                    String s=tickets.poll();
                    //判断后没有对队列做修改操作
                    if(s==null){
                        break;
                    }else {
                        System.out.println("销售了："+s);
                    }
                }
            }).start();
        }
    }
}
