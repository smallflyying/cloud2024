package com.atguigu.cloud.controller;

import com.atguigu.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/26
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() {
        return "---------------testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        return "---------------testB";
    }


    /* ===================================== */

    /**
     * 流控-链路演示demo
     * C和D两个请求都访问flowLimitService.common()方法, 阈值到达后对C限流，对D不管
     */
    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping(value = "/testC")
    public String testC() {
        flowLimitService.common();
        return "---------------testC";
    }

    @GetMapping(value = "/testD")
    public String testD() {
        flowLimitService.common();
        return "---------------testD";
    }
}
