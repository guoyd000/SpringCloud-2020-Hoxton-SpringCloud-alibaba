package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王柳
 * @date 2020/4/2 14:17
 */
@SpringBootApplication
@EnableDiscoveryClient //  该注解用于向使用consul或者Zookeeper作为注册中心时注册服务
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class, args);
    }
}
