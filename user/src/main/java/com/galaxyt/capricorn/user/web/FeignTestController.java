package com.galaxyt.capricorn.user.web;


import com.galaxyt.capricorn.common.model.dto.ReturnValueLoader;
import com.galaxyt.capricorn.core.service.order.IOrderService;
import com.galaxyt.capricorn.core.service.order.Test1Dto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignTestController {


    @Autowired
    private IOrderService orderService;

    @GetMapping("test1")
    public ReturnValueLoader test1() {


        Test1Dto dto = new Test1Dto();

        dto.setUsername("zhouqi");
        dto.setPassword("s12432432");

        return this.orderService.testFeignTest1(dto, "asdlfjasdlfjasd");

    }


    @HystrixCommand(fallbackMethod = "test2Fallback")
    @GetMapping("test2")
    public String test2() {

        int i = 1/0;

        return "success";
    }


    public String test2Fallback() {
        return "erlsdjfsdlkjf";
    }




}
