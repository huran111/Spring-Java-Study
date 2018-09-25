package com.hr.disruptor.demo;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author huran
 * @Title: LongEventProducer
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/259:18
 */
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }
    public  void onData(ByteBuffer bb){
        //可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽
        long sequence=ringBuffer.next();
        try {
            //用上面的索引取出一个空的事件用于填充
            LongEvent event = ringBuffer.get(sequence);// for the sequence
            event.setValue(   bb.getLong(0));
        }finally {
            ringBuffer.publish(sequence);
        }
    }
}
