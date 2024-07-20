package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/19
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer myRetryer()
    {
        return Retryer.NEVER_RETRY; //Feign默认配置是不走重试策略的

        //最大请求次数为3(1+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
        //return new Retryer.Default(100,1,3);
    }

    // 配置Feign日志级别, 可选值：NONE,BASIC,HEADERS,FULL,默认为NONE
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
