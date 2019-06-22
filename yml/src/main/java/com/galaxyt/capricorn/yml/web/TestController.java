package com.galaxyt.capricorn.yml.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Value("${galaxyt.name}")
    private String username;

    @Value("${galaxyt.sex}")
    private String sex;




    @GetMapping("test1")
    public void test1() {

        System.out.println(this.username);

        System.out.println(this.sex);

    }





}
