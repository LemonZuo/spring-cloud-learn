package com.lemonzuo.service.impl;

import com.lemonzuo.mapper.AccountMapper;
import com.lemonzuo.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2021-02-27 15:28
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    @GlobalTransactional(name = "order", rollbackFor = Exception.class)
    public void decrease(String userId, Integer money) {
        log.info("=====扣减余额=====");
        accountMapper.updateAccount(userId, money);
        log.info("=====扣减成功=====");
    }
}
