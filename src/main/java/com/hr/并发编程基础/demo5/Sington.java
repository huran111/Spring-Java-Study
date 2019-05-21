package com.hr.并发编程基础.demo5;

/**
 * @Description TODO
 * @auther huran
 * @date
 **/
public class Sington {
    private Sington() {
        System.out.println("ssss");
    }

    private static class Inner {
        private static Sington s = new Sington();
    }

    public static Sington getSington() {
        return Inner.s;
    }

    public static void main(String[] args) {

    }
}
