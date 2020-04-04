package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王柳
 * @date 2020/4/4 16:49
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 达到的目的，用我们重新选择的随机算法替代默认的轮询
        return new RandomRule();
    }
}
