package com.galaxyt.capricorn.user.dto;

import com.galaxyt.capricorn.user.enums.UserAvailable;

public class UserLoginDto {



    private Long id;

    private String username;

    private String password;

    private UserAvailable available;

    private String note;

    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
