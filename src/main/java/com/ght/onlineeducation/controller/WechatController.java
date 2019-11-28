package com.ght.onlineeducation.controller;

import com.ght.onlineeducation.config.WeChatConfig;
import com.ght.onlineeducation.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private WeChatConfig weChatConfig;


    @RequestMapping("/login")
    @ResponseBody
    public JsonData loginUrl(@RequestParam(value = "access_page",required = true) String accessPage) throws UnsupportedEncodingException {

        String redirectUrl = weChatConfig.getOpenRedirectUrl();
        String callbackUrl = URLEncoder.encode(redirectUrl,"GBK");
        String qrcodeUrl = String.format(weChatConfig.getOpenQrcodeUrl(),weChatConfig.getOpenAppId(),callbackUrl,accessPage);
        return JsonData.buildSuccess(qrcodeUrl);

    }

    @RequestMapping("/user/callback")
    public void wechatUserCallback (@RequestParam(value = "code",required = true) String code, String state, HttpServletResponse response) {

        System.out.println("code---"+code);
        System.out.println("state---"+state);

    }

}
