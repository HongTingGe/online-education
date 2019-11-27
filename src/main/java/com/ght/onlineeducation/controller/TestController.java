package com.ght.onlineeducation.controller;

import com.ght.onlineeducation.config.WeChatConfig;
import com.ght.onlineeducation.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private VideoMapper videoMapper;

    @RequestMapping("/test/config")
    @ResponseBody
    public String test1(){
        return weChatConfig.getAppId()+" --- "+weChatConfig.getAppSecret();
    }

}
