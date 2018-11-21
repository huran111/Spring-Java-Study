package com.hr.thread;


import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2017:29
 * @copyright {@link www.hndfsj.com}
 */
public class TwinsLock implements Lock {
    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must  large than zero.");
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            System.out.println("tryAcquireShared-arg:"+arg);
            for (; ; ) {
                int current = getState();
                System.out.println("当前状态tryAcquireShared："+current);
                int newCount = current - arg;
                System.out.println("current - arg:"+newCount);

                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            System.out.println("tryReleaseShared-arg:"+arg);

            for (; ; ) {
                int current = getState();
                System.out.println("当前状态tryReleaseShared："+current);

                int newCount = current + arg;
                System.out.println("current + arg:"+newCount);
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
