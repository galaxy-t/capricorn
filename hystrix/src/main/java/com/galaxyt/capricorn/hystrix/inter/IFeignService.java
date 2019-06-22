package com.galaxyt.capricorn.hystrix.inter;

import com.galaxyt.capricorn.hystrix.fallback.FeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign接口
 * 用于测试在没有注册到Eureka和服务端断掉情况下熔断器的使用
 * @author zhouqi
 * @date 2019-06-05 15:32
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-05 15:32     zhouqi          v1.0.0           Created
 *
 */
@FeignClient(value = "order",fallbackFactory = FeignFallbackFactory.class)
public interface IFeignService {


    @GetMapping("/feign/test1")
    String userInfo(@RequestParam Long userId);



}
