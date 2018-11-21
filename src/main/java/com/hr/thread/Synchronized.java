package com.hr.thread;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2015:03
 * @copyright {@link www.hndfsj.com}
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class){
            m();
        }
    }

    private static synchronized void m() {
    }
}
