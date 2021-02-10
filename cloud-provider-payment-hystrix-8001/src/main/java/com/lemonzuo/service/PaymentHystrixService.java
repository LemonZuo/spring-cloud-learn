package com.lemonzuo.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    /*====服务熔断====*/

    /**
     * @param id
     * @return
     * circuitBreaker.enabled: 是否开启断路器
     * circuitBreaker.requestVolumeThreshold: 请求次数
     * circuitBreaker.sleepWindowInMilliseconds: 时间窗口期
     * circuitBreaker.errorThresholdPercentage: 失败率达到多少执行降级操作
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value ="true" ),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value ="10" ),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value ="1000" ),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value ="60" ),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        if (id < 0) {
            throw new RuntimeException("ID不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        String result = Thread.currentThread().getName() + "\t" + "调用流水号：" + uuid;
        return result;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Long id) {
        String result = "ID 不能为负数";
        return result;
    }
}
