package com.atguigu.cloud;

import java.time.ZonedDateTime;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/14
 */
public class Main {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}