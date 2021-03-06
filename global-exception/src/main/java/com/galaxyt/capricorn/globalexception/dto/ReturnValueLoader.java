package com.galaxyt.capricorn.globalexception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 返回值装载器
 * @author zhouqi
 * @date 2019-01-13 23:22
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-01-13 23:22     zhouqi          v1.0.0           Created
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReturnValueLoader {


    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private String msg;

    /**
     * 要返回的数据
     * 注：若data为null，data节点将不会出现在json中
     */
    private Object data;


    public ReturnValueLoader() {
        super();
    }

    /**
     *
     * @param code  状态码
     * @param msg   状态信息
     */
    public ReturnValueLoader(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     *
     * @param code  状态码
     * @param msg   状态信息
     * @param data  要返回的数据
     */
    public ReturnValueLoader(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
