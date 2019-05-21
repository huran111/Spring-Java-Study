package com.hr.并发编程基础.demo4;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @auther huran
 * @date
 **/
public class ThreadLocal1 {
    volatile static Person p = new Person();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(p.name);

        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
           p.name="list";

        }).start();
    }
}

class Person {
    String name = "huran";
}