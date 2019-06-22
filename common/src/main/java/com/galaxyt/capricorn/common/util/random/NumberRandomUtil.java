package com.galaxyt.capricorn.common.util.random;

import java.util.Random;

/**
 * 数字随机数工具类
 * @author zhouqi
 * @date 2019-01-13 23:03
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-01-13 23:03     zhouqi          v1.0.0           Created
 *
 */
public class NumberRandomUtil {


    /**
     * 返回一个介于0和bound（不包括）之间的一个伪随机数
     * @param bound 随机数界限
     * @return 可能情况：大于等于0，小于bound
     */
    public static int randomInt(int bound) {
        Random random = new Random();

        return random.nextInt(bound);
    }


    /**
     * 返回一个字符串格式的数字随机数
     * @param length 要生成的字符串的长度，期待的数值应该大于0
     * @return 将返回指定长度的随机数字符串，若指定长度小于或等于0则返回一个空字符串
     *  例如：
     *      length=4  result=3279
     *      length=1  result=8
     *      length=0  result=""
     *      length=-1 result=""
     */
    public static String randomString(int length) {

        StringBuffer sb = new StringBuffer();

        for (int i=0;i<length;i++) {

            sb.append(NumberRandomUtil.randomInt(1));

        }

        return sb.toString();
    }






}
