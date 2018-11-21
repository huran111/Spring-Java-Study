package com.hr.thread;

import sun.java2d.cmm.Profile;

import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2015:50
 * @copyright {@link www.hndfsj.com}
 */
public class ProFiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL=new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.nanoTime();
        }
    };
    public static final void begin(){
        TIME_THREADLOCAL.set(System.nanoTime());
    }
    public static  final  long end(){
       return System.nanoTime()-TIME_THREADLOCAL.get();
    }
    public static final  void remove(){
        TIME_THREADLOCAL.remove();
    }
    public static void main(String[] args) throws InterruptedException {
        ProFiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(ProFiler.end()+" mills");
        ProFiler.remove();
    }
}
