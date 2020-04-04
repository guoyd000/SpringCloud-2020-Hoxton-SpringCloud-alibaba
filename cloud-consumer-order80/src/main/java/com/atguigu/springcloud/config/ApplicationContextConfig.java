package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 王柳
 * @date 2020/4/2 15:11
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
