package com.galaxyt.capricorn.core.service.order;

import com.galaxyt.capricorn.common.model.dto.ReturnValueLoader;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "order",fallbackFactory = OrderFallbackFactory.class)
public interface IOrderService {


    @PostMapping("/feign/test1/{token}")
    ReturnValueLoader testFeignTest1(Test1Dto test1Dto,
                                     @PathVariable("token") String token);


}
