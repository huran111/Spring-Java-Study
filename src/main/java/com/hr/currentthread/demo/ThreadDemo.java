package com.hr.currentthread.demo;

import java.util.concurrent.locks.Lock;

/**
 * @author huran
 * @Title: ThreadDemo
 * @ProjectName java-spring
 * @Description: 胡冉
 * @date 2018/10/2413:02
 */
class Res {
    public String name;
    public String age;
    //false表示读线程没有读取值
    public boolean flag=false;
}

/**
 * 写入线程
 */
class InpThread extends Thread {
    private Res res;

    public InpThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;

        while (true) {
            synchronized (res) {
                if (res.flag) { //true
                    //当前线程等待 编程休眠状态 类似于sleep wait是使用在多线程之前进行同步的  wait是可以释放锁的，而sleep是不会释放锁的
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                if (count == 0) {
                    res.name = "成龙";
                    res.age = "男";
                } else {
                    res.name = "刘亦菲";
                    res.age = "女";
                }
                count = (count + 1) % 2;
                res.flag = true;
                res.notify();
            }
        }

    }
}

class OutThread extends Thread {
    private Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (res) {
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "---------" + res.name + "--------" + res.age);
                res.flag = false;
                res.notify();
            }
        }
    }
}

public class ThreadDemo {

    /**
     *
     *  wait notify为什么放在object中
     *  如果用this.wait 或者 notify就直接报错了。  一定要和synchronized同时使用
     *  就是有的时候用多线程进行同步的时候， 有的时候同步锁可能是个类，所以直接放到object中去
     *  synchronized不能自动开锁解锁
     * @param args
     */
    public static void main(String[] args) {
        Res res = new Res();
        new InpThread(res).start();
        new OutThread(res).start();
    }
}
