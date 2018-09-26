package com.hr.aop2;

/**
 * @author huran
 * @Title: JdkDynamicAopProxy
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2614:08
 */

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.lang.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于 JDK 动态代理的代理对象生成器
 * Created by code4wt on 17/8/16.
 */
final public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler {

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
        super(advisedSupport);
    }

    /**
     * InvocationHandler 接口中的 invoke 方法具体实现，封装了具体的代理逻辑
     *
     * @param proxy
     * @param method
     * @param args
     * @return 代理方法或原方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

    /**
     * 为目标 bean 生成代理对象
     *
     * @return bean 的代理对象
     */
    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Object getProxy(@Nullable ClassLoader classLoader) {
        return null;
    }
}
