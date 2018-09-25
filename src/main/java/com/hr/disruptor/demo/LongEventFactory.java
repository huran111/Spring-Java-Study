package com.hr.disruptor.demo;

import com.lmax.disruptor.EventFactory;

/**
 * @author hruan
 * @Title: LongEventFactory
 * @ProjectName java-spring
 * @Description: 由于需要让Disruptor为我们创建事件，我们同时还声明了一个EventFactory来实例化Event对象。
 * @date 2018/9/259:15
 */
public class LongEventFactory implements EventFactory {

    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
