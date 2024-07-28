package com.atguigu.cloud.service;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/28
 */
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
