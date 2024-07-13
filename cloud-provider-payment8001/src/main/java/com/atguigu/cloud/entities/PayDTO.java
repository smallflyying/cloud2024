package com.atguigu.cloud.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/13
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(title = "支付交易表DTO")
public class PayDTO implements Serializable {

    @Schema(title = "主键")
    private Integer id;
    //支付流水号
    @Schema(title = "支付流水号")
    private String payNo;
    //订单流水号
    @Schema(title = "订单流水号")
    private String orderNo;
    //用户账号ID
    @Schema(title = "用户账号ID")
    private Integer userId;
    //交易金额
    @Schema(title = "交易金额")
    private BigDecimal amount;
}
