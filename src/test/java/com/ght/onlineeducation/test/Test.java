package com.ght.onlineeducation.test;

import com.ght.onlineeducation.domain.User;
import com.ght.onlineeducation.utils.JwtUtils;
import io.jsonwebtoken.Claims;

public class Test {

    @org.junit.Test
    public void test1(){
        User user = new User();
        user.setId(1);
        user.setName("ting");
        user.setHeadImg("www.ght.com");
        System.out.println(JwtUtils.geneJsonWebToken(user));

    }

    @org.junit.Test
    public void test2(){

        Claims claims = JwtUtils.checkJWT("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvbmxpbmUtZWR1Y2F0aW9uIiwiaWQiOjEsIm5hbWUiOiJ0aW5nIiwiaW1nIjoid3d3LmdodC5jb20iLCJpYXQiOjE1NzQ5MDk2NjMsImV4cCI6MTU3NDkwOTcyM30.D6jNU9j87P8wkaADb4huMF9ECeDK0ZKCsDY9d9ELqOk");
        System.out.println("id----"+claims.get("id"));
        System.out.println("name---"+claims.get("name"));
        System.out.println("img---"+claims.get("img"));

    }
}
