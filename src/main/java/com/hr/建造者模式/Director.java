package com.hr.建造者模式;

/**
 * @author BUCHU
 * @Title: Director
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/917:37
 */
public class Director {
    public Human createHumanByDirecotr(IBuildHuman bh) {
        bh.buildBody();
        bh.buildFoot();
        bh.buildHand();
        bh.buildHead();
        return bh.createHuman();
    }
}
