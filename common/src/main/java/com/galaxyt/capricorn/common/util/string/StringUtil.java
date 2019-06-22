package com.galaxyt.capricorn.common.util.string;


import java.io.UnsupportedEncodingException;

/**
 * 字符串工具类
 * @author zhouqi
 * @date 2019-01-14 00:34
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-01-14 00:34     zhouqi          v1.0.0           Created
 *
 */
public class StringUtil {


    /**
     * 检查字符串是否为null或空字符串
     * @param string
     * @return 若为null或空字符串返回true，否则返回false
     */
    public static boolean isNullEmpty(String string) {
        return string == null || "".equals(string.trim());
    }


    /**
     * 字符串转码，可用于url传递参数中的中文
     * @param string    要进行转码的字符串
     * @return
     */
    public static String changeCharset(String string) {
        try {
            byte[] bytes = string.getBytes("ISO-8859-1");
            return new String(bytes);
        } catch (UnsupportedEncodingException e) {
            return null;
        }

    }



}
