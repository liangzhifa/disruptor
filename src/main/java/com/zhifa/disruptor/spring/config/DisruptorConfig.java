package com.zhifa.disruptor.spring.config;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.zhifa.disruptor.spring.MessageEvent;
import com.zhifa.disruptor.spring.MessageEventFactory;
import com.zhifa.disruptor.spring.MessageEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class DisruptorConfig {

    @Autowired
    private MessageEventFactory messageEventFactory;

    @Autowired
    public MessageEventHandler messageEventHandler;

    @Bean
    public MessageEvent messageEvent() {
        return new MessageEvent();
    }

    @Bean("messageEventRingBuffer")
    public RingBuffer<MessageEvent> messageEventRingBuffer() {
        // Executor that will be used to construct new threads for consumers
        Executor executor = Executors.newCachedThreadPool();
        int bufferSize = 1024;
        // Construct the Disruptor
        Disruptor<MessageEvent> disruptor = new Disruptor<MessageEvent>(messageEventFactory, bufferSize, executor);
        // Connect the handler
        disruptor.handleEventsWith(messageEventHandler);
        // Start the Disruptor, starts all threads running
        disruptor.start();
        // Get the ring buffer from the Disruptor to be used for publishing.
        return disruptor.getRingBuffer();
    }

}
