package com.galaxyt.capricorn.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)      //将枚举当作一个对象处理，若需要将该枚举类型解析成JSON，需要用到该注解，否则会解析成一个字符串常量
public enum UserAvailable {

    OK(1, "好的"),
    ERROR(2,"不好的")
    ;

    /**
     * 使用EnumValue注解标识该属性与数据库字段进行映射
     */
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
