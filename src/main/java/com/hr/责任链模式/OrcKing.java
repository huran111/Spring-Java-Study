package com.hr.责任链模式;

/**
 * @author BUCHU
 * @Title: OrcKing
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/109:24
 */
public class OrcKing {
    RequestHandler chain;
    public OrcKing(){
        buildChain();
    }

    private void buildChain() {
        chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
    }
    public void makeRequest(Request req) {
        chain.handleRequest(req);
    }
}
