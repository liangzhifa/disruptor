package com.zhifa.disruptor.spring;

import com.lmax.disruptor.RingBuffer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class MessageEventProducer {
    @Resource(name = "messageEventRingBuffer")
    private RingBuffer<MessageEvent> messageEventRingBuffer;

    public void sendData(String value) {
        //可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽
        long sequence = messageEventRingBuffer.next();

        try {
            //用上面的索引取出一个空的事件用于填充
            MessageEvent messageEvent = messageEventRingBuffer.get(sequence);// for the sequence
            messageEvent.setMessage(value);

        } finally {
            //发布事件
            log.info("发布事件");
            messageEventRingBuffer.publish(sequence);
        }
    }

}
