package com.galaxyt.capricorn.core.service.order;

import javax.validation.constraints.NotBlank;

public class Test1Dto implements java.io.Serializable {

    private static final long serialVersionUID = 1L;


    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
