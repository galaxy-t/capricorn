package com.galaxyt.capricorn.core.service.order;

import com.galaxyt.capricorn.common.model.dto.ReturnValueLoader;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderFallbackFactory implements FallbackFactory<IOrderService> {
    @Override
    public IOrderService create(Throwable throwable) {

        return new IOrderService() {
            @Override
            public ReturnValueLoader testFeignTest1(Test1Dto test1Dto, String token) {
                return new ReturnValueLoader(5900, "熔断器测试");
            }
        };

    }
}
