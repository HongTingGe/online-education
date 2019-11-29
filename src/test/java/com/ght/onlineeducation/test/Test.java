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

        Claims claims = JwtUtils.checkJWT("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvbmxpbmUtZWR1Y2F0aW9uIiwiaWQiOjEsIm5hbWUiOiLlvIDlp4vmh4LkuoYiLCJpbWciOiJodHRwOi8vdGhpcmR3eC5xbG9nby5jbi9tbW9wZW4vdmlfMzIvUTBqNFR3R1RmVElVTEJOeE5HM1VDSmV5Ym1pYWJpY1c4blpUMmZ1T3A2R1hYQjJkR0w0aHNybzdLRGF4RVFqamtrNlludk92SDNZOUxGbDNLbWt5cWpRdy8xMzIiLCJpYXQiOjE1NzUwMTIyNjAsImV4cCI6MTU3NTAxMjMyMH0._JPsaG4LT43SqMlMjgsC7tAMLXf-xexjkr8pmVYqnho");
        System.out.println("id----"+claims.get("id"));
        System.out.println("name---"+claims.get("name"));
        System.out.println("img---"+claims.get("img"));

    }
}
