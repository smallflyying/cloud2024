package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main83 {

    public static void main(String[] args) {
        SpringApplication.run(Main83.class, args);
    }

}