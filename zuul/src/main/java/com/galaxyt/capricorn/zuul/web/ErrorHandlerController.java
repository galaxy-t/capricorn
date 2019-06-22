package com.galaxyt.capricorn.zuul.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.galaxyt.capricorn.common.model.dto.ReturnValueLoader;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 网关全局异常拦截
 * 拦截网关接收到或自身产生的一些错误异常，如请求地址找不到，或者请求的服务产生异常，对这些异常进行处理使用
 * @author zhouqi
 * @date 2019-06-06 15:29
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-06 15:29     zhouqi          v1.0.0           Created
 *
 */
@RestController
public class ErrorHandlerController implements ErrorController {


    @Autowired
    private ErrorAttributes errorAttributes;


    /**
     * 返回错误响应地址
     * @return
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }


    /**
     * 错误处理地址
     * @param request
     * @return
     */
    @RequestMapping("/error")
    public ReturnValueLoader error(HttpServletRequest request) {


        Map<String, Object> errorAttributes = getErrorAttributes(request);
        String message = (String) errorAttributes.get("message");
        String trace = (String) errorAttributes.get("trace");
        if (StringUtils.isNotBlank(trace)) {
            message += String.format(" and trace %s", trace);
        }
        //获取错误码
        int status = Integer.parseInt(errorAttributes.get("status").toString());

        /*
        针对错误吗进行判断
         */
        if (status == 404) {
            return new ReturnValueLoader(404, message + "sdflj");
        }
        return new ReturnValueLoader(500, message);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        return errorAttributes.getErrorAttributes(new ServletWebRequest(request), true);
    }
}
