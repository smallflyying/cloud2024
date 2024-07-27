package com.atguigu.cloud.controller;

import com.atguigu.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    /**
     * 流控效果------排队等待
     * @return
     */
    @GetMapping(value = "/testE")
    public String testE() {
        System.out.println(System.currentTimeMillis() + "     testE,流控效果------排队等待");
        return "---------------testE";
    }

    /**
     * 新增熔断规则-慢调用比例
     * @return
     */
    @GetMapping(value = "/testF")
    public String testF() {
        // 暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("------测试: 新增熔断规则-慢调用比例 ");
        return "------testF 新增熔断规则-慢调用比例";
    }

    /**
     * 新增熔断规则-异常比例
     * @return
     */
    @GetMapping(value = "/testG")
    public String testG() {
        System.out.println("------测试:新增熔断规则-异常比例");
        int age = 10/0;
        return "------testG,新增熔断规则-异常比例";
    }

    /**
     * 新增熔断规则-异常数
     * @return
     */
    @GetMapping(value = "/testH")
    public String testH() {
        System.out.println("------测试:新增熔断规则-异常数");
        int age = 10/0;
        return "------testH,新增熔断规则-异常数";
    }
}
