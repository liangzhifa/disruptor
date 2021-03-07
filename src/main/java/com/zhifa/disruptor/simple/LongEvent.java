package com.zhifa.disruptor.simple;

import lombok.Data;
import lombok.ToString;

/*
*
* 我们从一个简单的例子开始学习Disruptor：生产者传递一个long类型的值给消费者，
* 而消费者消费这个数据的方式仅仅是把它打印出来。
定义一个Event
首先定义一个Event来包含需要传递的数据
* */
@Data
@ToString
public class LongEvent {
    private long value;

}
