package com.hr.并发编程基础.demo7;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @author 胡冉
 * @ClassName TranferQueueDemo
 * @Date 2019/5/20 14:30
 * @Version 2.0
 */
public class TranferQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        strs.transfer("aaaa");
        strs.put("aaa");
        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
