package com.lemonzuo.service.impl;

import com.lemonzuo.mapper.StorageMapper;
import com.lemonzuo.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2021-02-27 15:51
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;
    @Override
    @GlobalTransactional(name = "order", rollbackFor = Exception.class)
    public void decrease(String productId, Integer count) {
        log.info("=====开始扣减库存=====");
        storageMapper.updateStorage(productId, count);
        log.info("=====库存扣减成功=====");
    }
}
