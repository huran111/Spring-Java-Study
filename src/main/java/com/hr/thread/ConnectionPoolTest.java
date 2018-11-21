package com.hr.thread;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2016:35
 */
public class ConnectionPoolTest {

    /**
     * 初始化 10 连接
     */
    static ConnectionPool pool = new ConnectionPool(10);
    /**
     * 保证所有ConnectionRunner能够同时开始
     */
    static CountDownLatch start = new CountDownLatch(1);
    /**
     * main线程将会等待所有ConnectionRunner结束后才能继续运行
     */
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGet = new AtomicInteger();
        for(int i=0;i<threadCount;i++){
            Thread thread=new Thread(new ConnetoionRunner(count,got,notGet),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("总数:"+threadCount*count);
        System.out.println("获取到的连接数:"+got);
        System.out.println("未获取到的连接数:"+notGet);
    }
    static class ConnetoionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;
        public ConnetoionRunner(int count, AtomicInteger got,
                                AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }
        @Override
        public void run() {
            try {
                start.await();
            }catch (Exception ex){}
            while (count>0){
                try {
                    //从线程池中获取连接，如果1000ms没有获取到，返回null，
                    // 分别统计连接池获取到的数据和未获取到数量
                    Connection connection=pool.fetchConnection(1000);
                    if(connection!=null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        }finally {
                                pool.releaseConnection(connection);
                                got.incrementAndGet();
                        }

                    }else {
                        notGot.incrementAndGet();
                    }
                }catch (Exception ex){}finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
