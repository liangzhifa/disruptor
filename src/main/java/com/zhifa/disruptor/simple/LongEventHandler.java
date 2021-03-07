package com.zhifa.disruptor.simple;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 我们还需要一个事件消费者，也就是一个事件处理器。这个事件处理器简单地把事件中存储的数据打印到终端：
 */
@Slf4j
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) throws Exception {
        if (longEvent.getValue() == 2L) {
           // Thread.sleep(20000);
        }
       log.info("longEvent:{},sequence:{},endOfBatch:{}",longEvent,sequence,endOfBatch);
    }
}
