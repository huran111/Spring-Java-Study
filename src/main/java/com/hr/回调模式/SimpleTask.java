package com.hr.回调模式;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BUCHU
 * @Title: SimpleTask
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/109:57
 */
public class SimpleTask  extends Task{
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTask.class);

    @Override
    public void execute() {
        LOGGER.info("执行一些重要的活动，然后调用回调方法");
    }
}
