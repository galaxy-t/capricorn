package com.galaxyt.capricorn.common.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间类型工具类
 * @author zhouqi
 * @date 2019-04-03 22:55
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-04-03 22:55     zhouqi          v1.0.0           Created
 *
 */
public class DateUtil {


    /**
     * 将一个字符串转换为时间类型
     * @param str       要转换的字符串
     * @param pattern   字符串的时间格式
     * @return
     * @throws ParseException
     */
    public static Date getDateFromStr(String str, String pattern) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.parse(str);

    }


    /**
     * 将一个时间类型转换成字符串
     * @param date      要转换的时间对象
     * @param pattern   要转换成的字符串的格式
     * @return
     */
    public static String getStrFromDate(Date date, String pattern) {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);

    }



}
