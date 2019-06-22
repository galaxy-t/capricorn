package com.galaxyt.capricorn.common.util.verification;

/**
 * 正则表达式验证
 * @author zhouqi
 * @date 2019-01-25 23:59
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-01-25 23:59     zhouqi          v1.0.0           Created
 *
 */
public class RegexUtil {


    /**
     * 验证手机号码
     * @param phoneNumber
     * @return
     */
    public static boolean phoneNumber(String phoneNumber) {
        return phoneNumber.matches("^1[0-9]{10}$");
    }


}
