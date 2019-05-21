package com.hr.并发编程基础.demo3;

/**
 * @Description TODO
 * @auther huran
 * @date
 **/
public class Test2 {
    public static void testIPlus() {
        int i = 0;
        int j = i++;
        System.out.println(i);
        System.out.println(j);
    }

    public  static void testPlusI() {
        int i = 0;
        int j = ++i;
        System.out.println(i);
        System.out.println(j);
    }

    public static void main(String[] args) {
        testIPlus();
        testPlusI();
    }
}
