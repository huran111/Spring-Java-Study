package com.hr.currentthread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    public Lock lock = new ReentrantLock();
    public boolean flag = false;
    Condition condition = lock.newCondition();
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
        try {
            while (true) {
                res.lock.lock();
                if (res.flag) {
                    try {
                        res.condition.await();
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
                res.condition.signal();
            }
        } finally {
            res.lock.unlock();
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
        try {
            while (true) {
                res.lock.lock();
                if (!res.flag) {
                    try {
                        res.condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "---------" + res.name + "--------" + res.age);
                res.flag = false;
                res.condition.signal();

            }
        } finally {
            res.lock.unlock();
        }

    }
}

public class ThreadDemo {

    /**
     * wait notify为什么放在object中
     * 如果用this.wait 或者 notify就直接报错了。  一定要和synchronized同时使用
     * 就是有的时候用多线程进行同步的时候， 有的时候同步锁可能是个类，所以直接放到object中去
     * synchronized不能自动开锁解锁
     *
     * @param args
     */
    public static void main(String[] args) {
        Res res = new Res();
        new InpThread(res).start();
        new OutThread(res).start();
    }
}
