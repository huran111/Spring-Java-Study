package com.hr.桥接模式;

/**
 * @author BUCHU
 * @Title: App
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/918:18
 */
public class App {
    public static void main(String[] args) {
        Hammer hammer = new Hammer(new FlyingEnchantment());
        hammer.wield();
        hammer.swing();
        hammer.unwield();
    }
}
