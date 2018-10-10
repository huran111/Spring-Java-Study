package com.hr.责任链模式;

/**
 * @author BUCHU
 * @Title: OrcSoldier
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/109:26
 */
public class OrcSoldier extends RequestHandler {
    public OrcSoldier(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request req) {
        //收集税收
        if (req.getRequestType().equals(RequestType.COLLECT_TAX)) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc soldier";
    }
}
