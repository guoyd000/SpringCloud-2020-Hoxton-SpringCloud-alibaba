package com.atguigu.springcloud.alibaba;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 王柳
 * @date 2020/4/23 13:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoDataSourceProxy
public class SeataOrderMainApp3001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp3001.class, args);
    }
}
