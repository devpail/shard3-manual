package com.hyc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2020-04-18 20:41
 **/
@Data
@TableName("t_user")
public class User {
    private Long userId;
    private String idNumber;
    private String name;
    private Integer age;
    private Integer gender;
    private Date birthDate;
}
