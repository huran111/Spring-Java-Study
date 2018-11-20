package com.hr.currentthread.demo;

/**
 * @author huran
 * @Title: Demo2
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2414:48
 */
class StopThread extends Thread{
    //flag为true表示线程开启状态
    public  boolean flag=true;
    @Override
    public void run() {
        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                StopThread();
            }
            System.out.println(Thread.currentThread().getName()+"----我是子线程");
        }

    }
    public   void StopThread(){
        flag=false;
    }
}
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        StopThread s=  new StopThread();
        s.start();
        StopThread a=  new StopThread();
        a.start();

        for(int i=0;i<30;i++){
            Thread.sleep(100);
            if(i==29){
                s.interrupt();
                a.interrupt();
            }
        }
        System.out.println("main.......................");
    }
}
