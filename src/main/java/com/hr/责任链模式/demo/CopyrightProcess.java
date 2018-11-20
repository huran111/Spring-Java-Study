package com.hr.责任链模式.demo;

/**
 * @author 版权处理
 * @Title: CopyrightProcess
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2917:58
 */
public class CopyrightProcess implements Process {
    @Override
    public void doProcess(String msg) {
        System.out.println(msg + "版权处理");
    }
}
