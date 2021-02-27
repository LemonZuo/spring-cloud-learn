package com.lemonzuo.controller;

import com.lemonzuo.mapper.StorageMapper;
import com.lemonzuo.model.CommonResult;
import com.lemonzuo.service.StorageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2021-02-27 15:50
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @PostMapping("storage/decrease")
    public CommonResult decrease(@RequestParam("productId") String productId,
                                 @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        CommonResult<Object> result = new CommonResult<>(200, "库存扣减成功");
        return result;
    }
}
