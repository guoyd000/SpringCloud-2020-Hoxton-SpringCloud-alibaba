package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 王柳
 * @date 2020/4/23 13:42
 */
@Mapper
public interface StorageDao {

    // 扣减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}

