package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 王柳
 * @date 2020/4/13 16:24
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_OK,id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时放，演示降级
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        Integer tumeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(tumeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时: " + tumeNumber + "秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "/(ToT)/调用支付接口超时或异常：\t" + "\t当前线程池名字：" + Thread.currentThread().getName();
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreadker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreadker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreadker_fallback(Integer id) {
        return "id 不能为负数,请稍后再试，~~~~(>_<)~~~~ id:  " + id;
    }
}
