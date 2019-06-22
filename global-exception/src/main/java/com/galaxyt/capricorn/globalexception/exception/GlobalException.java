package com.galaxyt.capricorn.globalexception.exception;

import com.galaxyt.capricorn.globalexception.enums.GlobalExceptionCode;

/**
 * 全局异常
 * @author zhouqi
 * @date 2019-06-02 18:15
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-02 18:15     zhouqi          v1.0.0           Created
 *
 */
public class GlobalException extends RuntimeException {


    private static final long serialVersionUID = 1L;


    private GlobalExceptionCode code;

    public GlobalExceptionCode getCode() {
        return code;
    }

    public void setCode(GlobalExceptionCode code) {
        this.code = code;
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, GlobalExceptionCode code) {
        super(message);
        this.code = code;
    }

}
