package com.hr.责任链模式;

/**
 * @author BUCHU
 * @Title: OrcCommander
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/109:18
 */
public class OrcCommander extends RequestHandler {
    public OrcCommander(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request request) {
        //防守城堡
        if(request.getRequestType().equals(RequestType.DEFEND_CASTLE)){
            printHandling(request);
            request.markHandled();
        }else {
            super.handleRequest(request);
        }
    }

    @Override
    public String toString() {
        return "Orc commander";
    }
}
