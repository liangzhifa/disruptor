package com.zhifa.disruptor.spring;

import com.lmax.disruptor.EventHandler;
import com.zhifa.disruptor.domain.WxUserInfo;
import com.zhifa.disruptor.mapper.WxUserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageEventHandler implements EventHandler<MessageEvent> {

    @Autowired
    public WxUserInfoMapper wxUserInfoMapper;

    @Override
    public void onEvent(MessageEvent messageEvent, long l, boolean b) throws Exception {
        log.info("messageEvent:{}",messageEvent);
        WxUserInfo wxUserInfo = new WxUserInfo();
        wxUserInfo.setRemark("disruptor:"+messageEvent.getMessage());
        wxUserInfoMapper.insert(wxUserInfo);
    }
}
