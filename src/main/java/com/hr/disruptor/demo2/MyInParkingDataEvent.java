package com.hr.disruptor.demo2;

/**
 * @author BUCHU
 * @Title: MyInParkingDataEvent
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2313:50
 */
public class MyInParkingDataEvent {
    //车牌号
    private String carLicense;

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }
}
