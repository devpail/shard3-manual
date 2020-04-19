package com.hyc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2020-04-18 20:44
 **/
@Data
@TableName("t_product")
public class Product {
    private Long productId;
    private String code;
    private String name;
    private String desc;
}
