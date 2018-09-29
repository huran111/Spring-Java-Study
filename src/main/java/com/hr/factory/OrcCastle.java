package com.hr.factory;

/**
 * @author BUCHU
 * @Title: OrcCastle
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/299:10
 */
public class OrcCastle implements Castle {
    static final String DESCRIPTION = "This is the Orc castle!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
