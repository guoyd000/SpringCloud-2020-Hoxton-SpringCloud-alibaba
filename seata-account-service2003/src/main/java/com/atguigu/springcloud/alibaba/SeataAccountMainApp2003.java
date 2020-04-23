package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 王柳
 * @date 2020/4/23 13:37
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源自动创建
@EnableDiscoveryClient
@EnableFeignClients
public class SeataAccountMainApp2003 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApp2003.class, args);
    }
}
