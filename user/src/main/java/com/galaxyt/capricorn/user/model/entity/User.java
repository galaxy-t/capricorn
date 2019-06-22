package com.galaxyt.capricorn.user.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.galaxyt.capricorn.user.enums.UserAvailable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.galaxyt.springclouddemo.user.model.entity.User", description = "用户信息详情")
@TableName("t_user")
public class User{


    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;

    @TableField(value = "username",exist = true,strategy = FieldStrategy.NOT_EMPTY)
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "available")
    private UserAvailable available;

    @TableField(value = "note")
    private String note;

    @Version
    private Integer version;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public UserAvailable getAvailable() {
        return available;
    }

    public void setAvailable(UserAvailable available) {
        this.available = available;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
