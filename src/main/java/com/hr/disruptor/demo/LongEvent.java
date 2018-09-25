package com.hr.disruptor.demo;

/**
 * @author huran
 * @Title: LongEvent
 * @ProjectName java-spring
 * @Description: 定义事件，也就是线程交换的数据
 * @date 2018/9/2313:26
 */
public class LongEvent {
    private long value;

    public void set(long value) {
        this.value = value;
    }
}
