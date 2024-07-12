package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/13
 */
@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
public class Main8001 {

    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}