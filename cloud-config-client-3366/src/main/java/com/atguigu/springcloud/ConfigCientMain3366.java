package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 王柳
 * @date 2020/4/17 9:14
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigCientMain3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCientMain3366.class, args);
    }
}
