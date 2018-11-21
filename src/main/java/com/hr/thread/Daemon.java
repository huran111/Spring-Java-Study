package com.hr.thread;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2014:29
 * @copyright {@link www.hndfsj.com}
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread=new Thread(new DaemonRunner(),"DaemonRuner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);

            } finally {
                System.out.println("Daemon Thread finally run");
            }
        }
    }
}
