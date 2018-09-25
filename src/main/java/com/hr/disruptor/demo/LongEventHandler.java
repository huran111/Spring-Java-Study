package com.hr.disruptor.demo;


import com.lmax.disruptor.EventHandler;

/**
 * @author BUCHU
 * @Title: LongEventHandler
 * @ProjectName java-spring
 * @Description: 我们还需要一个事件消费者，也就是一个事件处理器。这个事件处理器简单地把事件中存储的数据打印到终端：
 * @date 2018/9/259:16
 */
public class LongEventHandler  implements EventHandler<LongEvent> {


    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("消费到数据为:"+longEvent.getValue());
    }
}
