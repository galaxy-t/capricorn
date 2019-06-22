package com.galaxyt.capricorn.shardingjdbc.inter;

import com.galaxyt.capricorn.shardingjdbc.entity.Common;
import com.galaxyt.capricorn.shardingjdbc.entity.User;

import java.util.List;

public interface IUserService {
    void save();

    List<User> list();

    void add();

    void defaultAdd();

    List<Common> defaultList();
}
