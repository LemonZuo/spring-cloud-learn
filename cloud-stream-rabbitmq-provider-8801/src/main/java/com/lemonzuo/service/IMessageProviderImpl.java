package com.lemonzuo.service;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2021-02-11 18:41
 * 定义消息推送管道
 */
@EnableBinding(Source.class)
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {
    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serialNumber = IdUtil.simpleUUID();
        Message<String> message = MessageBuilder.withPayload(serialNumber).build();
        output.send(message);
        log.info("serialNumber:{}", serialNumber);
        return null;
    }
}
