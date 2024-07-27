package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/27
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
