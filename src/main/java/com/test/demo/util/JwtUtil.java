package com.test.demo.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

public class JwtUtil {

    private static long time = 1000 * 60  * 30;

    private static String signature = "admin";

    public static String createToken(String username,String password){
        //构建jwt对象
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header
                //类型为jwt
                .setHeaderParam("typ", "JWT")
                //算法
                .setHeaderParam("alg", "HS256")
                //payload
                .claim("username", username)
                .claim("password", password)
                //主题
                .setSubject("admin-test")
                //有限时间
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        return jwtToken;
    }
}
