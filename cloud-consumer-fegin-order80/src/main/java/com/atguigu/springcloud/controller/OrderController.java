package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王柳
 * @date 2020/4/5 12:44
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentFeginService paymentFeginService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeginService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/fegin/timeout")
    public String paymentFeginTimeout(){
        return paymentFeginService.paymentFeginTimeout();
    }
}
