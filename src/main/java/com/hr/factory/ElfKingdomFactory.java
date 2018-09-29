package com.hr.factory;

/**
 * @author BUCHU
 * @Title: ElfKingdomFactory
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/299:14
 */
public class ElfKingdomFactory implements KingdomFactory {
    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }
}
