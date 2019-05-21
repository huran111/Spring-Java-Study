package com.hr.并发编程基础.demo7;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author 胡冉
 * @ClassName PriorityBlockingQueue
 * @Date 2019/5/20 14:44
 * @Version 2.0
 */
public class PriorityBlockingQueueDemo {
    public static PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<User>();

    public static void main(String[] args) {
        queue.add(new User(1, "a"));
        queue.add(new User(5, "b"));
        queue.add(new User(23, "c"));
        queue.add(new User(55, "d"));
        queue.add(new User(92, "e"));
        queue.add(new User(333, "f"));
        for (User user : queue) {
            try {
                System.out.println(queue.take().name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //静态内部类
    static class User implements Comparable<User> {

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        int age;
        String name;

        @Override
        public int compareTo(User o) {
            return this.age > o.age ? -1 : 1;
        }
    }
}


