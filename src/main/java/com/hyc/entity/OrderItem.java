package com.hyc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2020-04-18 20:44
 **/
@Data
@TableName("t_order_item")
public class OrderItem {
    private Long orderItemId;
    private Long orderId;
    private Long productId;
    private BigDecimal itemPrice;
    private int totalNum;
    private BigDecimal totalPrice;
    private Date orderTime;
    private Long userId;
}
