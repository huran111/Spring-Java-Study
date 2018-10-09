package com.hr.建造者模式;

/**
 * @author BUCHU
 * @Title: BuilderTest
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/917:38
 */
public class BuilderTest {
    public static void main(String[] args) {
        Director director = new Director();
        Human human = director.createHumanByDirecotr(new SmartManBuilder());
        System.out.println(human.getHead());
        System.out.println(human.getBody());
        System.out.println(human.getHand());
        System.out.println(human.getFoot());


    }
}
