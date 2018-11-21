package com.hr.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2015:14
 * @copyright {@link www.hndfsj.com}
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread=new Thread(new Wait(),"WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notofy=new Thread(new Notify(),"NotifyThread");
        notofy.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            //加锁 ，用有lock的  monitor
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + "flag is true, wait" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足的时候
                System.out.println(Thread.currentThread() + "flag is false, running" + new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }
    }
    static class  Notify implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread() + "唤醒:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notify();
                flag=false;
                SleepUtils.second(5);
            }
            synchronized (lock){
                System.out.println(Thread.currentThread() + "加锁:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);

            }
        }
    }
}
