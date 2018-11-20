package com.hr.责任链模式.demo;

/**
 * @author 敏感词处理
 * @Title: SensitiveWordProcess
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2917:57
 */
public class SensitiveWordProcess  implements  Process{

    @Override
    public void doProcess(String msg) {
            System.out.println(msg+"敏感词处理");
    }
}
