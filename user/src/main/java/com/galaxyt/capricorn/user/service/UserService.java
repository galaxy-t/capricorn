package com.galaxyt.capricorn.user.service;

import com.galaxyt.capricorn.user.enums.UserAvailable;
import com.galaxyt.capricorn.user.inter.IUserService;
import com.galaxyt.capricorn.user.model.entity.User;
import com.galaxyt.capricorn.user.vo.LoginVo;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Override
    public User login(LoginVo vo) {

        if (vo.getUsername().equals("zhouqi") && vo.getPassword().equals("123456")) {


            User user = new User();

            user.setId(1L);

            user.setUsername("周琦");
            user.setPassword("passwordlsjdflksd");
            user.setAvailable(UserAvailable.OK);
            user.setNote("这里是描述信息");

            return user;



        }

        return null;
    }
}
