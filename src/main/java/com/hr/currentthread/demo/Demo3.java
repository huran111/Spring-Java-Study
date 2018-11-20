package com.hr.currentthread.demo;

/**
 * @author huran
 * @Title: Demo3
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2415:12
 */
public class Demo3 {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++)
                {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是子线程:"+i);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        for(int i=0;i<30;i++){
            System.out.println("我是主线程:"+i);
        }
    }
}
