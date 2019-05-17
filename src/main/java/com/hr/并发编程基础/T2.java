package com.hr.并发编程基础;

/**
 * @author 胡冉
 * @ClassName T2
 * @Description: TODO
 * @Date 2019/5/17 16:32
 * @Version 2.0
 */
public class T2 {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }
    }
}
