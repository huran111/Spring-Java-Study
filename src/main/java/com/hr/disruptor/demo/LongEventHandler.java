package com.hr.disruptor.demo;


import com.lmax.disruptor.EventHandler;

/**
 * @author huran
 * @Title: LongEventHandler
 * @ProjectName java-spring
 * @Description: 定义事件处理的具体实现类
 * @date 2018/9/2313:30
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("Event:" + longEvent);
    }
}
