package com.hr.责任链模式.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huran
 * @Title: MsgProcessChain
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/308:54
 */
public class MsgProcessChain {
    private List<Process> chains = new ArrayList<>();

    /**
     * 添加责任链
     */
    public MsgProcessChain addChain(Process process) {
        chains.add(process);
        return this;
    }

    /**
     * 执行处理
     */
    public void process(String msg) {
        for (Process chain : chains) {
            chain.doProcess(msg);
        }
    }
}
