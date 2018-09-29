package com.hr.factory;

/**
 * @author BUCHU
 * @Title: OrcArmy
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:44
 */
public class OrcArmy implements Army {
    static final String description=" B-----这是一个强大的军队";
    @Override
    public String getDescription() {
        return description;
    }
}
