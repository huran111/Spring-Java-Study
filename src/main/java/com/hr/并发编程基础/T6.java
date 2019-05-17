package com.hr.并发编程基础;

/**
 * @author 胡冉
 * @ClassName T6
 * @Date 2019/5/17 17:26
 * @Version 2.0
 */
public class T6 {
    synchronized  void m(){
        System.out.println("m start");
    }

    public static void main(String[] args) {
            new TT().m();
    }
}
class  TT extends T6{
    @Override
    synchronized  void m(){
        super.m();
    }
}
