package com.hr.并发编程基础;

import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @ClassName T8
 * @Date 2019/5/17 19:17
 * @Version 2.0
 */
public class T8 {
    boolean running = true;

    void m() {
        System.out.println("===========start");
        while (running) {
           // System.out.println("===========end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T8 t8 = new T8();
        new Thread(t8::m, "t1").start();
        TimeUnit.SECONDS.sleep(1);
        t8.running = false;
    }
}
