package com.hr.并发编程基础;

/**
 * @author 胡冉
 * @ClassName T9
 * @Date 2019/5/17 20:22
 * @Version 2.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatitle并不能保证多个线程共同修改 running变量所带来的不一致性问题
 */
public class T10 {
    static AtomicInteger count=new AtomicInteger(0);
    void m(){
        for(int i=0;i<10000;i++){
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        T10 t9=new T10();
        List<Thread> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(new Thread(t9::m,"thread"+i));
        }
        list.forEach(x->{
            x.start();
        });
        list.forEach(o->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(count);
    }


}
