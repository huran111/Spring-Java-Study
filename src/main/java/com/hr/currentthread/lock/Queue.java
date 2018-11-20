package com.hr.currentthread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huran
 * @Title: Queue
 * @ProjectName java-spring
 * @Description: 有界队列
 * @date 2018/10/2414:03
 */
public class Queue<T> {
    private Object[] elements;
    private int length = 0, addIndex = 0, removeIndex = 0;
    private Lock lock = new ReentrantLock();
    //判断队列是否为空
    private Condition notEmpty = lock.newCondition();
    //判断队列是否已经满了
    private Condition notFull = lock.newCondition();

    public Queue(int size) {
        elements = new Object[size];
    }

    /**
     * 插入元素
     */
    public void add(T object) throws InterruptedException {
        lock.lock();
        try {
            while (length == elements.length) {
                notFull.await();
            }
            elements[addIndex] = object;
            if (addIndex++ == elements.length) {
                addIndex = 0;
            }
            System.out.println("添加元素："+elements.toString());
            length++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 取出元素
     */
    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (0 == length) {
                notEmpty.await();
            }
            Object element = elements[length];
            System.out.println("删除元素："+elements.toString());

            if (removeIndex++ == elements.length) {
                removeIndex = 0;
            }
            length--;
            notFull.signal();
            return (T) element;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Queue queue=new Queue(102);
        new Thread(()->{
            try {
                for(int i=1;i<100;i++){
                    Thread.sleep(30);
                    queue.remove();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
       new Thread(()->{
           try {
               for(int i=0;i<100;i++){
                   Thread.sleep(20);
                   queue.add("1");
               }

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }).start();

    }
}
