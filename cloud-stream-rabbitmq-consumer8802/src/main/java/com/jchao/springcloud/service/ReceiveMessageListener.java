package com.jchao.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ChangJinchao
 * @create 2022-07-30 21:11
 * @Description
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListener {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者1号，------->接收到的消息：" + message.getPayload() + "\t port: {}",serverPort);
//        System.out.println("消费者1号，------->接收到的消息：" + message.getPayload() + "\t port: " + serverPort);
    }

}
