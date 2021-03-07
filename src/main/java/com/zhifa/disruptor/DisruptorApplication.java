package com.zhifa.disruptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@MapperScan("com.zhifa.disruptor.mapper")
public class DisruptorApplication {


    public static void main(String[] args) {
        SpringApplication.run(DisruptorApplication.class, args);
    }

}
