package com.hr.currentthread;

import java.util.concurrent.CountDownLatch;

/**
 * @author huran
 * @Title: CountDownLatchDemo
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/811:12
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        Timer timer = new Timer(5);
        new Thread(timer).start();
        for (int athleteNo = 0; athleteNo < 5; athleteNo++) {
            new Thread(new Athlete(timer, "athlete" + athleteNo)).start();
        }
    }

}

class Timer implements Runnable {
    CountDownLatch timerController;

    public Timer(int num) {
        this.timerController = new CountDownLatch(num);
    }
    public void recordResult(String athleteName) {
        System.out.println(athleteName + " 已经到达");
        timerController.countDown();
        System.out.println("There are " + timerController.getCount() + " 运动员没有到达终点");
    }
    @Override
    public void run() {
        try {
            System.out.println("Start...");
            timerController.await();
            System.out.println("所有运动员都到了............");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Athlete implements Runnable {
    Timer timer;
    String athleteName;



    public Athlete(Timer timer, String athleteName) {
        this.timer = timer;
        this.athleteName = athleteName;
    }



    @Override
    public void run() {
        try {
            System.out.println(athleteName + " 开始跑");
            long duration = (long) (Math.random() * 10);
            Thread.sleep(duration * 1000);
            timer.recordResult(athleteName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}