package com.hr.currentthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author BUCHU
 * @Title: ConditionDemo
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/810:55
 */
public class ConditionDemo {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    System.out.println(Thread.currentThread().getName() + "在等待被唤醒");
                    condition.await();
                    System.out.println(Thread.currentThread().getName() + "回复执行了");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        },"线程1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
              try {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName()+"抢到了锁");
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"唤醒其他等待的线程");
              }catch (Exception e){
                  e.printStackTrace();
              }finally {
                  reentrantLock.unlock();
              }
            }
        },"线程2").start();
    }
}
