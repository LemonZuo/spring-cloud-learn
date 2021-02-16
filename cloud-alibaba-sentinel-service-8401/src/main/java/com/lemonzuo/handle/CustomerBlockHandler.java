package com.lemonzuo.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lemonzuo.model.CommonResult;

/**
 * @author LemonZuo
 * @create 2021-02-16 16:44
 */
public class CustomerBlockHandler {
    public static CommonResult masterHandleException(BlockException exception) {
        CommonResult result = new CommonResult(444,
                "按客户自定义，GlobalException---->master",
                exception.getClass().getCanonicalName());
        return result;
    }

    public static CommonResult slaverHandleException(BlockException exception) {
        CommonResult result = new CommonResult(444,
                "按客户自定义，GlobalException---->slaver",
                exception.getClass().getCanonicalName());
        return result;
    }
}
