package com.hr.ioc;

import org.junit.jupiter.api.Test;

/**
 * @author BUCHU
 * @Title: SimpleIOCTest
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2116:57
 */
public class SimpleIOCTest {
    @Test
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel.toString());
        Car car = (Car) bf.getBean("car");
        System.out.println(car.toString());
    }
}
