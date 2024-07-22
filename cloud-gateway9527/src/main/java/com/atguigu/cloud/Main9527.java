package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/22
 */
@SpringBootApplication
@EnableDiscoveryClient //服务注册和发现
public class Main9527 {

    public static void main(String[] args) {
        SpringApplication.run(Main9527.class, args);
    }
}