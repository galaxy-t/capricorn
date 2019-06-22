package com.galaxyt.capricorn.order.web;

import com.galaxyt.capricorn.common.model.dto.ReturnValueLoader;
import com.galaxyt.capricorn.core.service.order.Test1Dto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/feign")
public class TestFeignController {


    @Value("${username}")
    private String username;


    @PostMapping("test1/{token}")
    public ReturnValueLoader test1(@Valid @RequestBody Test1Dto test1Dto,
                                   @PathVariable("token") String token) throws InterruptedException {

        System.out.println(token);

        Thread.sleep(6000);

        System.out.println(test1Dto.getUsername());
        System.out.println(test1Dto.getPassword());

        return new ReturnValueLoader(1,"测试成功");
    }


    @GetMapping("test2")
    public String test2() {


        return this.username;
    }



}
