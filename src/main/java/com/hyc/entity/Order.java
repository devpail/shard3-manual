package com.hyc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2020-04-18 20:44
 **/
@Data
@TableName("t_order")
public class Order {
    private Long orderId;
    private String orderNo;
    private Long userId;
    private BigDecimal orderAmount;
    private int orderStatus;
    private String remark;
}
