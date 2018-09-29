package com.hr.factory;

/**
 * @author huran
 * @Title: OrcKing
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/299:11
 */
public class OrcKing implements King {
    static final String DESCRIPTION = "This is the Orc king!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
