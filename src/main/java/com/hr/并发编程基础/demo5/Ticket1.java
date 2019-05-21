package com.hr.并发编程基础.demo5;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @auther huran
 * @date
 **/
public class Ticket1 {
    static List<String> tockets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tockets.add("票号:" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tockets.size() > 0) {
                    System.out.println(Thread.currentThread().getName()+" 销售了:" + tockets.remove(0));
                }
            }).start();
        }
    }
}
