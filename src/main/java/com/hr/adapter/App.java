package com.hr.adapter;

/**
 * @author huran
 * @Title: App
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/1516:55
 */
public class App {
    public static void main(String[] args) {
        // The captain can only operate rowing boats but with adapter he is able to use fishing boats as well
        Captain captain = new Captain(new FishingBoatAdapter());
        captain.row();
    }
}
