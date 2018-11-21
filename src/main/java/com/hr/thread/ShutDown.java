package com.hr.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2014:55
 * @copyright {@link www.hndfsj.com}
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        Runner ont=new Runner();
        Thread count=new Thread(ont,"COunt");
        count.start();
        TimeUnit.SECONDS.sleep(1);
        count.interrupt();
        Runner two=new Runner();
        count=new Thread(two,"Count");
        count.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }
    private static class Runner implements Runnable{
        private long i;
        private volatile  boolean on =true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("count i:"+i);
        }
        public  void cancel(){
            on=false;
        }
    }
}
