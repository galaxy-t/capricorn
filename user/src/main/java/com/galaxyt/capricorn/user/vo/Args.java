package com.galaxyt.capricorn.user.vo;

import javax.validation.constraints.NotBlank;

public class Args {


    @NotBlank(message = "姓名不能为空")
    private String name;


    @NotBlank(message = "电话不能为空")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
