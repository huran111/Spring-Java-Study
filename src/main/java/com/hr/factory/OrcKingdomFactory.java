package com.hr.factory;

/**
 * @author BUCHU
 * @Title: OrcKingdomFactory
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/299:19
 */
public class OrcKingdomFactory implements KingdomFactory {
    @Override
    public Castle createCastle() {
        return new OrcCastle();
    }

    @Override
    public King createKing() {
        return new OrcKing();
    }

    @Override
    public Army createArmy() {
        return new OrcArmy();
    }
}
