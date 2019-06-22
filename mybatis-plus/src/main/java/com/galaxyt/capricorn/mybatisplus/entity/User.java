package com.galaxyt.capricorn.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.galaxyt.capricorn.mybatisplus.enums.UserAvailable;

@TableName("t_user")
public class User {

    @TableId(value = "id",type = IdType.ID_WORKER_STR)
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


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", available=" + available +
                ", note='" + note + '\'' +
                ", version=" + version +
                '}';
    }
}
