package com.hr.责任链模式;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BUCHU
 * @Title: RequestHandler
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/109:11
 */
public abstract class RequestHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);
    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handleRequest(Request request) {
        if (next != null) {
            next.handleRequest(request);
        }
    }

    protected void printHandling(Request request) {
        LOGGER.info("{} handling request \"{}\"", this, request);
    }
    @Override
    public abstract String toString();
}
