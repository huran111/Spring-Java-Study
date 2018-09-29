package com.hr.factory;

/**
 * @author BUCHU
 * @Title: ElfArmy
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:41
 */
public class ElfArmy implements  Army {
    static final String description=" A-----这是一个强大的军队";
    @Override
    public String getDescription() {
        return description;
    }
}
