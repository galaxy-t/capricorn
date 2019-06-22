package com.galaxyt.capricorn.zuul.filter;

import com.galaxyt.capricorn.common.enums.ResultCode;
import com.galaxyt.capricorn.common.model.dto.ReturnValueLoader;
import com.galaxyt.capricorn.common.util.encript.JWTUtil;
import com.galaxyt.capricorn.common.util.json.GsonUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 网关请求前置拦截器
 * 用于拦截请求头中是否带有TOKEN
 * @author zhouqi
 * @date 2019-06-06 15:47
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-06 15:47     zhouqi          v1.0.0           Created
 *
 */
@Component
public class AuthFilter extends ZuulFilter {


    private List<String> whiteApis = new ArrayList<>();



    private String secret = "abcd";

    public AuthFilter() {
        super();
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {


        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        String token = request.getHeader("token");
        // API白名单内直接放行
        if (whiteApis.contains(uri) || uri.contains("login")) {
            return null;
        }

        /*
        不在白名单中则进行Token验证是否为空
         */
        if (StringUtils.isBlank(token)) {
            ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);

            ctx.setResponseBody(GsonUtil.getJson(new ReturnValueLoader(ResultCode.NO_AUTH_CODE)));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }

        /**
         * 验证TOKEN是否有效
         */
        JWTUtil.JWTResult jwtResult = JWTUtil.getInstance().checkToken(token, this.secret);

        if (!jwtResult.isStatus()) {
            ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);
            ctx.setResponseBody(GsonUtil.getJson(new ReturnValueLoader(jwtResult.getCode(),jwtResult.getMsg())));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }

        ctx.addZuulRequestHeader("uid", jwtResult.getUid());
        return null;

        /*

        // 此token已经注销
        Long cacheResult = logoutCache.get(jwResult.getUid());
        if (cacheResult != null) {
            ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);
            ctx.setResponseBody(JsonUtils.toJson(Response.fail("非法请求", ResponseCode.NO_AUTH_CODE)));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }
        ctx.addZuulRequestHeader("uid", jwResult.getUid());
        return null;
    }*/


    }
}
