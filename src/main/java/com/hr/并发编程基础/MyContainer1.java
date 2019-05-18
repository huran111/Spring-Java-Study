package com.hr.并发编程基础;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @ClassName MyContainer1
 * @Date 2019/5/18 14:05
 * @Version 2.0
 */
public class MyContainer1 {
    List list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer1 myContainer1 = new MyContainer1();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myContainer1.add(new Object());
                System.out.println("add:" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (myContainer1.size() == 5) {
                    break;
                }
            }
            System.out.println("t2结束");
        }, "t2").start();
    }
}
