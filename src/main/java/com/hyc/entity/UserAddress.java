package com.hyc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2020-04-18 20:45
 **/
@Data
@TableName("t_user_address")
public class UserAddress {
    private Long addressId;
    private Long userId;
    private String province;
    private String city;
    private String district;
    private String detail;
    private int sort;
    private int gender;
}
