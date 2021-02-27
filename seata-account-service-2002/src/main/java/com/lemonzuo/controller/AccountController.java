package com.lemonzuo.controller;

import com.lemonzuo.model.CommonResult;
import com.lemonzuo.modle.Account;
import com.lemonzuo.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author LemonZuo
 * @create 2021-02-25 22:48
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping("account/decrease")
    public CommonResult decrease(@RequestParam("userId") String userId,
                                 @RequestParam("money") Integer money) throws InterruptedException {
        accountService.decrease(userId, money);
        TimeUnit.SECONDS.sleep(30);
        CommonResult<Object> result = new CommonResult<>(200, "扣减余额成功");
        return result;
    }
}
