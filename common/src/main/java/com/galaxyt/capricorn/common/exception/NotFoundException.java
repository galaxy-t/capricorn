package com.galaxyt.capricorn.common.exception;

import com.galaxyt.capricorn.common.enums.GlobalExceptionCode;

/**
 * 资源未找到异常
 * 如查询一个列表为NULL时
 * 根据id查询一个对象时
 * 基本上如果判定要查询的资源不存在均可以抛出该异常
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
public class NotFoundException extends GlobalException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message, GlobalExceptionCode.NOT_FOUND_EXCEPTION_CODE);
    }
}
