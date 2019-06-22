package com.galaxyt.capricorn.common.enums;

public enum ResultCode {

    SUCCESS(0, "SUCCESS"),

    USERNAME_OR_PASSWORD_ERROR(1001,"用户名或密码错误"),

    TOKEN_TIME_OUT(2001,"TOKEN过期"),

    NO_AUTH_CODE(2002,"TOKEN异常");


    private final int code;

    private final String msg;

    ResultCode(int code, String msg) {
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
