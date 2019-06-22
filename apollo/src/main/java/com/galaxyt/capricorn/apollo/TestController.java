package com.galaxyt.capricorn.apollo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    @Value("${username:abcd}")
    private String username;


    @GetMapping("test")
    public String test() {
        return this.username;
    }


}
