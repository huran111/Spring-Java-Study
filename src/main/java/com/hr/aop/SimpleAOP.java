package com.hr.aop;

import java.lang.reflect.Proxy;

/**
 * @author huran
 * @Title: SimpleAOP
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2117:13
 */
public class SimpleAOP {
    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(), bean.getClass().getInterfaces(), advice);
    }
}
