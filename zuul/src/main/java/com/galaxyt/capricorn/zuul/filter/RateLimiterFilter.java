package com.galaxyt.capricorn.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import com.google.common.util.concurrent.RateLimiter;


/**
 * RateLimiter限流过滤器
 * @author zhouqi
 * @date 2019-06-06 16:40
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-06 16:40     zhouqi          v1.0.0           Created
 *
 */
//@Component
public class RateLimiterFilter extends ZuulFilter {

    private RateLimiter rateLimiter = RateLimiter.create(1.0);


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        rateLimiter.acquire();
//		if (rateLimiter.tryAcquire()) {
//			System.err.println("获取到了");
//		}
        return null;
    }
}
