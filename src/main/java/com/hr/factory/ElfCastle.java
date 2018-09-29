package com.hr.factory;

/**
 * @author BUCHU
 * @Title: ElfCastle
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:42
 */
public class ElfCastle implements Castle {
    static final String description="A-----这是一个美丽的城堡";

    @Override
    public String getDescription() {
        return description;
    }
}
