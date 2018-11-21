package com.hr.thread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2016:19
 * @copyright {@link www.hndfsj.com}
 */
public class ConnectionDriver {
    /**
     * 动态构建 一个Connection 只是实现了在commint()方法抵用是休眠100 ms
     */
    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }
    /**
     * 创建一个Connection代理 在commit时休眠100 ms
     */
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]
                {Connection.class}, new ConnectionHandler());
    }
}
