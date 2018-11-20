package com.hr.责任链模式.demo;

/**
 * @author huran
 * @Title: Process
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2917:56
 */
public interface Process {
    /**
     * 执行处理
     */
    void doProcess(String msg);
}
