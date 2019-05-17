package com.hr.并发编程基础;

/**
 * @author 胡冉
 * @ClassName T3
 * @Description: 非静态代码块 锁定的是当前对象
 * @Date 2019/5/17 16:38
 * @Version 2.0
 */
public class T3 {
    private int count = 10;

    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count= " + count);
        }
    }
}
