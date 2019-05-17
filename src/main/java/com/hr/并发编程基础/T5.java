package com.hr.并发编程基础;

/**
 * @author 胡冉
 * @ClassName T5
 * @Description: TODO
 * @Date 2019/5/17 17:19
 * @Version 2.0
 */
public class T5 {
    synchronized  void  m1(){
         m2();
    }
    synchronized  void  m2(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

    }
}
