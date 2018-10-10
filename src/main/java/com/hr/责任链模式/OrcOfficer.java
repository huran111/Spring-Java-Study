package com.hr.责任链模式;

/**
 * @author BUCHU
 * @Title: OrcOfficer
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/109:25
 */
public class OrcOfficer extends RequestHandler {
    public OrcOfficer(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request req) {
        //折磨囚犯
        if (req.getRequestType().equals(RequestType.TORTURE_PRISONER)) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc officer";
    }
}
