package com.hr.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huran
 * @Title: Counter
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2916:52
 */
public class Counter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) throws InterruptedException {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<Thread>(600);
        long start = System.currentTimeMillis();
        for(int j=0;j<100;j++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                        for(int i=0;i<10000;i++){
                            cas.count();
                            cas.safeCount();
                        }
                }
            });
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }
        //等待所有线程执行完毕
        for (Thread t : ts) {
            t.join();
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.println("耗时："+(System.currentTimeMillis()-start));
    }
    /**
     * 使用cas实现线程安全计数器
     */
    private void safeCount(){
        for(;;){
            int i=atomicInteger.get();
            boolean s=atomicInteger.compareAndSet(i,++i);
            if(s){
                break;
            }
        }
    }
    /**
     * 非线程安全
     */
    private  void count(){
        i++;
    }
}
