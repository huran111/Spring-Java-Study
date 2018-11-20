package com.hr.回调模式;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BUCHU
 * @Title: LambdasApp
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/109:56
 */
public class LambdasApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(LambdasApp.class);

    public static void main(String[] args) {
        Task task=new SimpleTask();
        Callback c=()-> LOGGER.info("完成了");
        task.executeWith(c);
    }
}
