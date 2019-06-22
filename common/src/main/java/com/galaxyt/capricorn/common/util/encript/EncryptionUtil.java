package com.galaxyt.capricorn.common.util.encript;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * 未使用加盐算法
 * @author zhouqi
 * @date 2019-01-16 20:28
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-01-16 20:28     zhouqi          v1.0.0           Created
 *
 */
public class EncryptionUtil {

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f' };


    public static void main(String[] args) throws NoSuchAlgorithmException {

        String s = encode("zhouqi123456","MD5");

        System.out.println(s);
    }

    /**
     * 将字符串加密
     * 需要加盐建议自行拼接
     * @param str   要加密的字符串
     * @param algorithm 类型，MD5,SHA1
     * @return  返回一个32位的字符串，其中应为字符为大写
     */
    public static String encode(String str,String algorithm) {

        try {

            MessageDigest messageDigest =  messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }


    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }


}
