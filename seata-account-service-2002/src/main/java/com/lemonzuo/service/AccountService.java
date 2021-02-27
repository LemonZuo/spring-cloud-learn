package com.lemonzuo.service;

import com.lemonzuo.model.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LemonZuo
 * @create 2021-02-26 22:17
 */
public interface AccountService {

    void decrease(String userId, Integer money);
}
