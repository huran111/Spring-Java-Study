package com.hr.factory;

/**
 * @author BUCHU
 * @Title: ElfKing
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:42
 */
public class ElfKing implements King {
    static final String description="A-----这是一个牛逼的国王";

    @Override
    public String getDescription() {
        return description;
    }
}
