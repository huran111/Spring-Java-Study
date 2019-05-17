package com.hr.并发编程基础;

/**
 * @author 胡冉
 * @ClassName T4
 * @Description: TODO
 * @Date 2019/5/17 16:40
 * @Version 2.0
 */
public class T4 {

    private static int count=0;
        public static void mm(){
            synchronized (T4.class){
                count --;
            }
        }
}
