package com.hr.disruptor.demo;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huran
 * @Title: DisruptorTest
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2313:34
 */
public class DisruptorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        EventFactory<LongEvent> eventEventFactory = new LongEventFactory();
        //必须是2的N次方
        int ringbuffer = 1024 * 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventEventFactory, ringbuffer, executorService, ProducerType.SINGLE
                , new YieldingWaitStrategy());
        EventHandler<LongEvent>eventeEventHandler=new LongEventHandler();
        disruptor.handleEventsWith(eventeEventHandler);
        disruptor.start();
    }

}
