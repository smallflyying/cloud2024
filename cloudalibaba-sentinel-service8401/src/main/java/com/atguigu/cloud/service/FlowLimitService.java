package com.atguigu.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/26
 */
@Service
public class FlowLimitService {

    @SentinelResource(value = "common")
    public void common() {
        System.out.println("---------FlowLimitService come in");
    }
}
