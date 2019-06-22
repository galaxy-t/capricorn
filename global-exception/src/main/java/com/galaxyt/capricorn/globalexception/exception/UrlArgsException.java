package com.galaxyt.capricorn.globalexception.exception;

import com.galaxyt.capricorn.globalexception.enums.GlobalExceptionCode;

/**
 * URL通配变量异常
 * @author zhouqi
 * @date 2019-06-02 19:22
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-02 19:22     zhouqi          v1.0.0           Created
 *
 */
public class UrlArgsException extends GlobalException {

    private static final long serialVersionUID = 1L;

    public UrlArgsException(String message) {
        super(message, GlobalExceptionCode.URL_ARGS_EXCEPTION_CODE);
    }
}
