package com.hr.factory;

/**
 * @author BUCHU
 * @Title: KingdomFactory
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/299:13
 */
public interface KingdomFactory {
    Castle createCastle();

    King createKing();

    Army createArmy();
}
