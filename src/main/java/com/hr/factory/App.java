package com.hr.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huran
 * @Title: App
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/299:20
 */
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private King king;
    private Castle castle;
    private Army army;

    public void createKingDom(final KingdomFactory factory) {
        setKing(factory.createKing());
        setCastle(factory.createCastle());
        setArmy(factory.createArmy());
    }

    King getKing(final KingdomFactory factory) {
        return factory.createKing();
    }

    Castle getCastle(final KingdomFactory factory) {
        return factory.createCastle();
    }

    public enum KingdomType {
        ELF, ORC
    }

    /**
     * 根据类型创建不同的工厂
     *
     * @param type
     * @return
     * @throws IllegalAccessException
     */
    public static KingdomFactory makeFactory(KingdomType type) throws IllegalAccessException {
        switch (type) {
            case ELF:
                return new ElfKingdomFactory();
            case ORC:
                return new OrcKingdomFactory();
            default:
                throw new IllegalAccessException("不支持的类型");
        }
    }

    Army getArmy(final KingdomFactory factory) {
        return factory.createArmy();
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Castle getCastle() {
        return castle;
    }

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public static void main(String[] args) throws IllegalAccessException {
        App app = new App();
        app.createKingDom(makeFactory(KingdomType.ELF));
        System.out.println(app.getArmy().getDescription());
        System.out.println(app.getCastle().getDescription());
        System.out.println(app.getKing().getDescription());
        app.createKingDom(makeFactory(KingdomType.ORC));
        System.out.println(app.getArmy().getDescription());
        System.out.println(app.getCastle().getDescription());
        System.out.println(app.getKing().getDescription());
    }
}
