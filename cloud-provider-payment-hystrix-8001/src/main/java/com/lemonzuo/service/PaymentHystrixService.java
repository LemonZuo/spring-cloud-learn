package com.lemonzuo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * @author LemonZuo
 * @create 2020-09-17 21:33
 */
@Service
@Slf4j
public class PaymentHystrixService {
    public String hystrixOk(Long id) {
        log.info("8001-hystrixOk:{}", id);
        return "8001-hystrixOk:" + id;
    }

    /**
     * @param id
     * @return
     * @HystrixCommand 处理异常，超时情况
     * fallbackMethod属性：待调用方法名
     * commandProperties属性：具体属性配置
     * @HystrixProperty注解： 配置具体属性
     */
    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String hystrixTimeout(Long id) {
        int time = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("8001-hystrixTimeout:{},{}", id, time);
        return "8001-hystrixTimeout:id-" + id + ", time-" + time;
    }

    /**
     * Hystrix 异常处理方案
     *
     * @param id
     * @return
     */
    public String hystrixTimeoutHandler(Long id) {
        return "8001-Unavailable:系统服务暂时不可用" + id;
    }

}
