package com.galaxyt.capricorn.core.handler;

import com.galaxyt.capricorn.common.enums.GlobalExceptionCode;
import com.galaxyt.capricorn.common.exception.GlobalException;
import com.galaxyt.capricorn.common.model.dto.ReturnValueLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;


/**
 * 全局异常处理
 * @author zhouqi
 * @date 2019-06-02 18:26
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-02 18:26     zhouqi          v1.0.0           Created
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    private Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 系统异常处理   如404 500
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ReturnValueLoader defaultExceptionHandler(HttpServletRequest request, Exception e) throws Exception {


        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) { //404处理

            //全部的404异常
            return new ReturnValueLoader(404, e.getMessage());

        } else if (e instanceof MethodArgumentNotValidException) {  //注解参数异常处理

            //获取注解参数异常
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            //获取全部异常
            BindingResult bindingResult = exception.getBindingResult();
            //将全部异常信息以逗号分割拼接成字符串
            String message = bindingResult.getAllErrors().stream().map(s -> s.getDefaultMessage()).collect(Collectors.joining(","));

            return new ReturnValueLoader(GlobalExceptionCode.METHOD_ARGUMENT_EXCEPTION_CODE.getCode(), message);

        } else {

            return new ReturnValueLoader(500, e.getMessage());
        }

    }

    /**
     * 自定义异常处理
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public ReturnValueLoader customerExceptionHandler(HttpServletRequest request, GlobalException e) throws Exception {
        return new ReturnValueLoader(e.getCode().getCode(), e.getMessage());
    }


}
