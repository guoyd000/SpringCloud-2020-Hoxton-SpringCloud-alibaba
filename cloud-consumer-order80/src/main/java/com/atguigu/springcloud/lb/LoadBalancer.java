package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 王柳
 * @date 2020/4/4 17:26
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
