package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王柳
 * @date 2020/4/13 16:25
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallBackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @Value(("${server.port}"))
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
////    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(Integer id) {
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己，w(ﾟДﾟ)w";
    }

    /**
     * 全局fallback方法
     *
     * @return
     */
    public String payment_Global_FallBackMethod() {
        return "Global异常处理信息，请稍后再试，~~~~(>_<)~~~~";
    }
}
