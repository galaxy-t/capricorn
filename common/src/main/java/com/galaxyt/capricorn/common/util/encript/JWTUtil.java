package com.galaxyt.capricorn.common.util.encript;

import com.galaxyt.capricorn.common.enums.ResultCode;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 * 单利模式
 * 使用HS512加密算法
 * @author zhouqi
 * @date 2019-06-06 12:38
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-06 12:38     zhouqi          v1.0.0           Created
 *
 */
public class JWTUtil {


    private static class SingletonHolder {
        private static final JWTUtil INSTANCE = new JWTUtil();
    }


    public synchronized static JWTUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }


    /**
     * @param userId 需要保存的用户ID，字符串类型，也可以保存其他的想要保存的东西
     * @param secret 密钥，加密算法需要
     * @param exp    过期时间，单位分钟
     * @return
     */
    public String generateToken(String userId, int exp, String secret) {

        HashMap<String, Object> map = new HashMap<>();
        //也可以放置一些其他的参数
        map.put("userId", userId);

        long endTime = System.currentTimeMillis() + 1000 * 60 * exp;

        String token = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(endTime))// 1000 hour
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return token;

    }



    public JWTResult checkToken(String token, String secret) throws ExpiredJwtException, SignatureException {

        try {
            // parse the token.
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            return new JWTResult(true, body.get("userId").toString(),ResultCode.SUCCESS.getMsg(), ResultCode.SUCCESS.getCode());

        } catch (ExpiredJwtException e) {       //若TOKEN过期则直接抛错
            return new JWTResult(false, null,ResultCode.TOKEN_TIME_OUT.getMsg(), ResultCode.TOKEN_TIME_OUT.getCode());
        } catch (SignatureException e) {        //若签名验证失败则直接抛错
            return new JWTResult(false, null,ResultCode.NO_AUTH_CODE.getMsg(), ResultCode.NO_AUTH_CODE.getCode());
        }catch (Exception e) {
            return new JWTResult(false, null,ResultCode.NO_AUTH_CODE.getMsg(), ResultCode.NO_AUTH_CODE.getCode());
        }

    }



    public static class JWTResult {

        private boolean status;
        private String uid;
        private String msg;
        private int code;

        public JWTResult() {
            super();
        }

        public JWTResult(boolean status, String uid, String msg, int code) {
            super();
            this.status = status;
            this.uid = uid;
            this.msg = msg;
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }


}
