package com.ght.onlineeducation.controller;

import com.ght.onlineeducation.config.WeChatConfig;
import com.ght.onlineeducation.domain.JsonData;
import com.ght.onlineeducation.domain.User;
import com.ght.onlineeducation.service.UserService;
import com.ght.onlineeducation.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    @ResponseBody
    public JsonData loginUrl(@RequestParam(value = "access_page",required = true) String accessPage) throws UnsupportedEncodingException {

        String redirectUrl = weChatConfig.getOpenRedirectUrl();
        String callbackUrl = URLEncoder.encode(redirectUrl,"GBK");
        String qrcodeUrl = String.format(weChatConfig.getOpenQrcodeUrl(),weChatConfig.getOpenAppId(),callbackUrl,accessPage);
        return JsonData.buildSuccess(qrcodeUrl);

    }

    @RequestMapping("/user/callback")
    public void wechatUserCallback (@RequestParam(value = "code",required = true) String code, String state, HttpServletResponse response) throws IOException {

        User user = userService.saveWeChatUser(code);

        if (user!=null){
            String token = JwtUtils.geneJsonWebToken(user);
            response.sendRedirect(state+"?token="+token+"&head_img="+user.getHeadImg()+"&name="+URLEncoder.encode(user.getName(),"UTF-8"));
        }

    }

}
