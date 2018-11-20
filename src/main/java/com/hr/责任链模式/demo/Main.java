package com.hr.责任链模式.demo;

/**
 * @author huran\
 * @Title: Main
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/309:19
 */
public class Main {
    public static void main(String[] args) {
        String msg = "内容内容内容";
        MsgProcessChain chain = new MsgProcessChain()
                .addChain(new SensitiveWordProcess())
                .addChain(new CopyrightProcess());
        chain.process(msg);
    }
}
