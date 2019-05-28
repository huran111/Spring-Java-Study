package com.hr.并发编程基础.demo8;


import java.util.concurrent.Executor;

/**
 * @author 胡冉
 * @ClassName MyExecutor
 * @Date 2019/5/20 14:50
 * @Version 2.0
 */
public class MyExecutor implements Executor {
    public static void main(String[] args) {
        new MyExecutor().execute(()->System.out.println("hello "));
    }
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
