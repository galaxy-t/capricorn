package com.galaxyt.capricorn.hystrix.fallback;

import com.galaxyt.capricorn.hystrix.inter.IFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Feign接口错误回退接口
 * 当Feign的某个接口出现问题，如报错，请求超时等
 * 将使用到该类，该类中的create方法将为Feign接口中的每一个方法提供失败处理
 * @author zhouqi
 * @date 2019-06-05 15:49
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-05 15:49     zhouqi          v1.0.0           Created
 *
 */
@Component
public class FeignFallbackFactory implements FallbackFactory<IFeignService> {
    @Override
    public IFeignService create(Throwable throwable) {
        return new IFeignService() {


            @Override
            public String userInfo(Long userId) {
                return "熔断器测试";
            }
        };
    }
}
