package com.hr.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡冉
 * @Description: 线程的优先级
 * @date 2018/11/2014:02
 * @copyright {@link www.hndfsj.com}
 */
public class Priority {
    private static volatile boolean notStart = false;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws Exception {
        List<Job> jobs=new ArrayList<>(20);
        for(int i=0;i<10;i++){
            int priority=i<5?Thread.MIN_PRIORITY:Thread.MAX_PRIORITY;
            Job job=new Job(priority);
            jobs.add(job);
            Thread thread=new Thread(job,"Thread"+i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart=false;
        TimeUnit.SECONDS.sleep(10);
        notEnd=false;
        for(Job job:jobs){
            System.out.println(job.priority+":"+job.jobCount);
        }
    }
    static class Job implements Runnable {
        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                System.out.println("==notStart");
                Thread.yield();
            }
            while (notEnd) {
                System.out.println("==notEnd");

                Thread.yield();
                System.out.println("==notEnd2");

                jobCount++;
            }
        }
    }
}
