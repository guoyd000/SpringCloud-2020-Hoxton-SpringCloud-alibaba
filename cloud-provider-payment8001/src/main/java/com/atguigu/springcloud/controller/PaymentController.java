package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王柳
 * @date 2020/4/2 14:43
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果****：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功，服务端口：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败，服务端口：" + serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果****：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功，服务端口：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：，服务端口：" + serverPort + id);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        log.info("************" + list);

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }
}
