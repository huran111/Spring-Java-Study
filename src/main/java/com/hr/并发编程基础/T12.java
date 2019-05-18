package com.hr.并发编程基础;

import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @ClassName T12
 * @Description: TODO
 * @Date 2019/5/18 13:55
 * @Version 2.0
 */
public class T12 {
    String s1 = "hello";
    String s2 = "hello";

    void m1() {
        synchronized (s1) {
            System.out.println(this.toString());
            System.out.println("s1s1s1s1s1s1s1s1s1s1s1s1s1s1s1s1s1s1s1s1");
        }
    }

    void m2() {
        synchronized (s2) {
            System.out.println("s2s2s2s2s2s2s2s2s2s2s2s2s2s2s2");
            System.out.println(this.toString());


        }
    }

    public static void main(String[] args) throws InterruptedException {
        T12 t12=new T12();
        new Thread(t12::m1,"s1").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(t12::m2,"s2").start();


    }
}
