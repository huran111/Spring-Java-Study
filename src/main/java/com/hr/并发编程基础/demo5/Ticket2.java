package com.hr.并发编程基础.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @auther huran
 * @date
 **/
public class Ticket2 {
    static volatile Vector<String> tockets = new Vector<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tockets.add("票号:" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tockets.size() > 0) {
                    /**
                     * @TODO
                     */
                    System.out.println(Thread.currentThread().getName()+" 销售了:" + tockets.remove(0));
                }
            }).start();
        }
    }
}
