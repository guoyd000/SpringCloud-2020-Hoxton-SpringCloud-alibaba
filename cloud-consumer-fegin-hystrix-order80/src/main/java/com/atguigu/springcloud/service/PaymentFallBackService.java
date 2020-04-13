package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 王柳
 * @date 2020/4/13 17:59
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallBackService fall back-paymentInfo_OK,O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallBackService fall back-paymentInfo_TimeOut,~~~~(>_<)~~~~";
    }
}
