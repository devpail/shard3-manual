package com.hyc.enums;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2020-04-18 21:10
 **/

public enum OrderStatusEnum {
    PROCESSING(0);

    private Integer code;
    private OrderStatusEnum(Integer code) {
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
}
