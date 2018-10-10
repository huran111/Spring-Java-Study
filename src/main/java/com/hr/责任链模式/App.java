package com.hr.责任链模式;

/**
 * @author BUCHU
 * @Title: App
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/109:28
 */
public class App {
    public static void main(String[] args) {
        OrcKing king = new OrcKing();
        //king.makeRequest(new Request(RequestType.DEFEND_CASTLE, "保卫城堡"));
        //king.makeRequest(new Request(RequestType.TORTURE_PRISONER, "折磨囚犯"));
        king.makeRequest(new Request(RequestType.COLLECT_TAX, "收集税收"));
    }
}
