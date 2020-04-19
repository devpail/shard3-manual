package com.hyc.enums;

import javax.tools.Diagnostic;

public enum GenderEnum {
    MALE(0),FEMALE(1);

    private Integer code;
    private GenderEnum(Integer code) {
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
}
