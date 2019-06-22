package com.galaxyt.capricorn.globalexception.web;

import com.galaxyt.capricorn.globalexception.exception.UrlArgsException;
import com.galaxyt.capricorn.globalexception.vo.Args;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {


    @GetMapping("test1")
    public void test1() {
        throw new UrlArgsException("TEST1中URL通配异常测试");
    }


    @PostMapping("test2")
    public void test2(@Valid @RequestBody Args args) {

    }


}
