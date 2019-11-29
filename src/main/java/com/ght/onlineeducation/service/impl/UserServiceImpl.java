package com.ght.onlineeducation.service.impl;

import com.ght.onlineeducation.config.WeChatConfig;
import com.ght.onlineeducation.domain.User;
import com.ght.onlineeducation.service.UserService;
import com.ght.onlineeducation.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private WeChatConfig weChatConfig;

    @Override
    public User saveWeChatUser(String code) {

        String accessTokenUrl = String.format(WeChatConfig.getOpenAccessTokenUrl(),weChatConfig.getOpenAppId(),weChatConfig.getOpenAppSecret(),code);

        //获取access_token
        Map<String,Object> baseMap = HttpUtils.doGet(accessTokenUrl);
        if (baseMap==null || baseMap.isEmpty()){
            return null;
        }
        String accessToken = (String) baseMap.get("access_token");
        String openId = (String) baseMap.get("openid");


        //获取用户基本信息
        String openUserInfoUrl = String.format(WeChatConfig.getOpenUserInfoUrl(),accessToken,openId);

        Map<String,Object> baseUserMap = HttpUtils.doGet(openUserInfoUrl);
        if (baseUserMap==null || baseUserMap.isEmpty()){
            return null;
        }
        String nickname = (String) baseUserMap.get("nickname");
        String sex = (String) baseUserMap.get("sex");
        String province = (String) baseUserMap.get("province");
        String city = (String) baseUserMap.get("city");
        String country = (String) baseUserMap.get("country");
        String headimgurl = (String) baseUserMap.get("headimgurl");


        return null;
    }
}
