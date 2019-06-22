package com.galaxyt.capricorn.user.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserAvailable{

    OK(1, "好的"),
    ERROR(2,"不好的")
    ;

    @EnumValue
    private final int code;

    private final String msg;


    UserAvailable(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return msg;
    }
}
