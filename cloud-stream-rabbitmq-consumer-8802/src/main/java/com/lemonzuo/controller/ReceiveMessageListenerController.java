package com.lemonzuo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LemonZuo
 * @create 2021-02-12 16:59
 */
@Slf4j
@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message) {
        String messageContent = message.getPayload();
        log.info("消费者1号，端口号：{}，======》接收到消息为：{}", serverPort, messageContent);
    }
}
