package com.ght.onlineeducation.interceptor;

import com.ght.onlineeducation.domain.JsonData;
import com.ght.onlineeducation.utils.JwtUtils;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    private static final Gson gson = new Gson();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if (token == null){
            token = request.getParameter("token");
        }
        if (token!=null){
            Claims claims = JwtUtils.checkJWT(token);
            if (claims!=null){
                int id = (int) claims.get("id");
                String name = (String) claims.get("name");
                request.setAttribute("user_id",id);
                request.setAttribute("name",name);
                return true;
            }
        }

        sendJsonMessage(response, JsonData.buildError("请登录"));


        return false;
    }

    public static void sendJsonMessage(HttpServletResponse response , Object object) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(gson.toJson(object));
        printWriter.close();
        response.flushBuffer();
    }
}
