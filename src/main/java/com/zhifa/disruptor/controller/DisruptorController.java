package com.zhifa.disruptor.controller;

import com.zhifa.disruptor.mapper.WxUserInfoMapper;
import com.zhifa.disruptor.spring.MessageEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disruptor")
public class DisruptorController {

    @Autowired
    private MessageEventProducer messageEventProducer;


    @GetMapping("/{id}")
    public String get(@PathVariable String id) {
        messageEventProducer.sendData(id);

        return "666";
    }

}
