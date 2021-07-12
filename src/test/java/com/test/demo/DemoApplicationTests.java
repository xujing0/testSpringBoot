package com.test.demo;


import io.jsonwebtoken.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    private long time = 1000 * 60  * 30;

    private String signature = "admin";

    @Test
    public void jwt() {
        //构建jwt对象
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header
                //类型为jwt
                .setHeaderParam("typ", "JWT")
                //算法
                .setHeaderParam("alg", "HS256")
                //payload
                .claim("username", "tom")
                .claim("role", "admin")
                //主题
                .setSubject("admin-test")
                //有限时间
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        System.out.println(jwtToken);
    }

    @Test
    public void parse(){
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE2MjU4MzMyNTYsImp0aSI6ImU4NTE4NmFlLTc5M2ItNDNiMi04YmVkLTU3YzFiMzA1OTVmNSJ9.EvO0yvyjBOC5R5PCOGOkDze9gi2YrJXHSmqcF_WbFrs";
        JwtParser jwtParser=Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        System.out.println("claims.get(\"username\") = " + claims.get("username"));
        System.out.println("claims.get(\"role\") = " + claims.get("role"));
        System.out.println("claims.getId() = " + claims.getId());
        System.out.println("claims.getSubject() = " + claims.getSubject());
        System.out.println("claims.getExpiration() = " + claims.getExpiration());
    }

    public static void main(String[] args) {
        int num = 2147483647 ;
        num += 2L ;
        System.out.println(num) ;
    }
}
