package com.hr.thread;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2016:16
 * @copyright {@link www.hndfsj.com}
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                //连接释放后 需要进行通知，其他消费者能够感知连接池中 已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }
    /**
     * 在mills内无法获取到连接 将会返回为null
     */
    public Connection fetchConnection(long mills) throws Exception {
        synchronized (pool) {
            //完全超时
            if (mills < 0) {
                //为空时等待
                while (pool.isEmpty()) {
                    pool.wait();
                }
                //移除一个连接并返回结果
                return pool.removeFirst();
            } else {
                //当前时间加超时时间
                long future = System.currentTimeMillis() + mills;
                //超时时间
                long remaining = mills;
                //队列为空且 没有超时
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
