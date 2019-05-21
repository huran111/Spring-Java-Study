package com.hr.并发编程基础;

/**
 * @author 胡冉
 * @ClassName demo
 * @Date 2019/5/17 16:22
 * @Version 2.0
 */
public class T implements Runnable{
    private   int count=100;
    @Override
    public  /*synchronized*/ void run(){
        count --;
        System.out.println(Thread.currentThread().getName()+":"+count);
    }

    public static void main(String[] args) {
        T demo=new T();
        for(int i=0;i<100;i++){
            new Thread(demo,"thread"+i).start();
        }
    }
}
