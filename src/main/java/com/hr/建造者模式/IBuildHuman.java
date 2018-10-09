package com.hr.建造者模式;

/**
 * @author BUCHU
 * @Title: IBuildHuman
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/917:35
 */
public interface IBuildHuman {
     void buildHead();
     void buildBody();
     void buildHand();
     void buildFoot();
     Human createHuman();
}
