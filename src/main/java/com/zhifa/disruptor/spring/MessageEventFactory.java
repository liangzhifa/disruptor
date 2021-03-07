package com.zhifa.disruptor.spring;

import com.lmax.disruptor.EventFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageEventFactory implements EventFactory<MessageEvent> {
    @Autowired
    private MessageEvent messageEvent;
    @Override
    public MessageEvent newInstance() {
        return messageEvent;
    }
}
