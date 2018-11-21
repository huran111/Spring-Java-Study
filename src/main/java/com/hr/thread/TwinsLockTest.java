package com.hr.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2017:44
 * @copyright {@link www.hndfsj.com}
 */
public class TwinsLockTest {
    @Test
    public  void test(){
        final Lock lock=new TwinsLock();
        class  Worker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
        for(int i=0;i<20;i++){
            Worker w=new Worker();
            w.setDaemon(true);
            w.start();
        }
        for(int i=0;i<20;i++){
            SleepUtils.second(1);
            System.out.println("===================");
        }
    }
}
