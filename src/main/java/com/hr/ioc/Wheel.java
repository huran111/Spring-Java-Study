package com.hr.ioc;

/**
 * @author BUCHU
 * @Title: Wheel
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2116:56
 */
public class Wheel {
    private String brand;
    private String specification ;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "brand='" + brand + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }
}
