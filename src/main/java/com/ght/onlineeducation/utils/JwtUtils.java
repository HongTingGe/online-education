package com.ght.onlineeducation.utils;

import com.ght.onlineeducation.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {

    private static final String SUBJECT = "online-education";
    private static final long EXPIRE = 1000*60; //过期时间，毫秒为单位
    private static final String APPSECRET = "ght9712";//秘钥

    public static String geneJsonWebToken(User user){

        if (user == null ||user.getId()==null || user.getName()==null || user.getHeadImg()== null){
            return null;
        }

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("name",user.getName())
                .claim("img",user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET)
                .compact();

        return token;
    }

    public static Claims checkJWT(String token){
        try{
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception exception){
            return null;
        }
    }

}
