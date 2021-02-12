package com.lemonzuo.controller;

import com.lemonzuo.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2021-02-12 14:06
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("sendMessage")
    public String sendMessage() {
        String send = messageProvider.send();
        return send;
    }
}
