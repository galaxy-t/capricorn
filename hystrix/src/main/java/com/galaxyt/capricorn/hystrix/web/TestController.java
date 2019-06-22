package com.galaxyt.capricorn.hystrix.web;

import com.galaxyt.capricorn.hystrix.inter.IFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private IFeignService feignService;

    /**
     * 测试Feign熔断功能
     * @return
     */
    @GetMapping("test1")
    public String test1() {


        return this.feignService.userInfo(1234L);

    }


    /**
     * 测试本地熔断功能
     * @return
     */
    @HystrixCommand(fallbackMethod = "test2Fallback")
    @GetMapping("test2")
    public String test2() {

        int i = 1/0;

        return "1111";
    }


    public String test2Fallback() {
        return "222";
    }


}
