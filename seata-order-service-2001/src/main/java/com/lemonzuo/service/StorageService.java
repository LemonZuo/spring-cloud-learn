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
@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("storage/decrease")
    CommonResult decrease(@RequestParam(value = "productId") String productId,
                          @RequestParam(value = "count") Integer count);
}
