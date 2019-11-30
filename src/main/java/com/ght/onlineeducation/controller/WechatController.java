package com.ght.onlineeducation.controller;

import com.ght.onlineeducation.config.WeChatConfig;
import com.ght.onlineeducation.domain.JsonData;
import com.ght.onlineeducation.domain.User;
import com.ght.onlineeducation.service.UserService;
import com.ght.onlineeducation.utils.JwtUtils;
import com.ght.onlineeducation.utils.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

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

    @RequestMapping("/order/callback")
    public void wechatOrderCallback (HttpServletRequest request, HttpServletResponse response) throws Exception {

        InputStream inputStream = request.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine())!= null){
            sb.append(line);
        }
        br.close();
        inputStream.close();
        Map<String,String> callbackMap = WXPayUtil.xmlToMap(sb.toString());
        System.out.println("-----------微信返回sign----------");
        System.out.println(callbackMap.get("sign"));
        System.out.println("--------------------------------");
    }

}
