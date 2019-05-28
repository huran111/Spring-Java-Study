package com.hr.并发编程基础.demo8;

import com.hr.thread.Interrupted;

import java.util.concurrent.*;

/**
 * @author 胡冉
 * @ClassName FutrueDemo
 * @Date 2019/5/20 17:05
 * @Version 2.0
 */
public class FutrueDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });
        new Thread(task).start();
        System.out.println(task.get());
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());
    }
}
