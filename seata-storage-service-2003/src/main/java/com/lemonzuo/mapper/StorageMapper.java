package com.lemonzuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author LemonZuo
 * @create 2021-02-27 15:45
 */
@Mapper
public interface StorageMapper {
    void updateStorage(@Param("productId") String productId,
                       @Param("count") Integer count);
}
