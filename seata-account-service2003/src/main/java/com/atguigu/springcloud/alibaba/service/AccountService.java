package com.atguigu.springcloud.alibaba.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author 王柳
 * @date 2020/4/23 14:54
 */
public interface AccountService {

    // 扣减账户
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
