package com.galaxyt.capricorn.user.web;

import com.galaxyt.capricorn.common.model.dto.ReturnValueLoader;
import com.galaxyt.capricorn.user.enums.UserAvailable;
import com.galaxyt.capricorn.user.model.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("test3")
    public ReturnValueLoader test3(@RequestHeader("uid") String userId) {

        System.out.println(userId + "=====================");

        User user = new User();

        user.setId(1L);

        user.setUsername("周琦");
        user.setPassword("passwordlsjdflksd");
        user.setAvailable(UserAvailable.OK);
        user.setNote("这里是描述信息");

        return new ReturnValueLoader(0, "success", user);
    }


    @GetMapping("test4")
    public String test4() {
        return "SUCCESS";
    }



}
