package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王柳
 * @date 2020/4/23 14:10
 */
@Configuration
@MapperScan({"com.atguigu.springcloud.com.atguigu.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
