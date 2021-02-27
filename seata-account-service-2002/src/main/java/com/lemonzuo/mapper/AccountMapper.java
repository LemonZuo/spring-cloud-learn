package com.lemonzuo.mapper;

import com.lemonzuo.modle.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LemonZuo
 * @create 2021-02-25 22:47
 */
@Mapper
public interface AccountMapper {
    void updateAccount(@Param("userId") String userId, @Param("money") Integer money);
}
