package com.hr.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2014:38
 * @copyright {@link www.hndfsj.com}
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepRunner(),"SleepThread");
        thread.setDaemon(true);
        Thread thread1=new Thread(new BusyRunner(),"BusyRunner");
        thread1.setDaemon(true);
        thread.start();
        thread1.start();
        //休眠5秒让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();
        thread1.interrupt();
        //防止 两个线程 立即退出
        System.out.println("SleepRunner:"+thread.isInterrupted());
        System.out.println("BUsyRunner:"+thread1.isInterrupted());
        SleepUtils.second(10);
    }

    /**
     * 不停的睡眠
     */
    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    /**
     * 不停的运行
     */
    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
