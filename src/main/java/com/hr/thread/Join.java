package com.hr.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2015:37
 * @copyright {@link www.hndfsj.com}
 */
public class Join {
    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous),String.valueOf("第一个"+i));
            thread.start();
          previous=thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + "  :sdsd");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println(Thread.currentThread().getName() + "  :sdsd");
        }
    }
}
