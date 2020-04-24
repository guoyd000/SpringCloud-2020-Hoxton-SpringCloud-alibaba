package com.atguigu.springcloud.alibaba.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author 王柳
 * @date 2020/4/23 13:53
 */
public interface StorageService {
    // 扣减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
