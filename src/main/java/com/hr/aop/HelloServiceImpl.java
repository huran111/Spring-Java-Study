package com.hr.aop;

/**
 * @author BUCHU
 * @Title: HelloServiceImpl
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2117:15
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHelloWorld() {
        System.out.println("hello world!");
    }
}
