package com.hr.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2014:19
 * @copyright {@link www.hndfsj.com}
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
