package com.hr.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2014:45
 * @copyright {@link www.hndfsj.com}
 */
public class Deprecated {
    public static void main(String[] args) throws InterruptedException {
        DateFormat format=new SimpleDateFormat("HH:mm:ss");
        Thread printThread=new Thread(new Runner(),"PringThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        printThread.suspend();
        System.out.println("pringThread:"+format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        printThread.resume();
        System.out.println("pringThread:"+format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        printThread.stop();
        System.out.println("pringThread:"+format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

    }
    static class Runner implements Runnable{
        @Override
        public void run() {
            DateFormat format=new SimpleDateFormat("HH:mm:ss");
            while (true){
                System.out.println(Thread.currentThread().getName()+"Run at"+ format.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
