package com.zhifa.disruptor.simple;

import com.lmax.disruptor.EventFactory;

/*由于需要让Disruptor为我们创建事件，我们同时还声明了一个EventFactory来实例化Event对象。*/
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
