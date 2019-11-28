package com.ght.onlineeducation.service.impl;

import com.ght.onlineeducation.config.WeChatConfig;
import com.ght.onlineeducation.domain.User;
import com.ght.onlineeducation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private WeChatConfig weChatConfig;

    @Override
    public User saveWeChatUser(String code) {

        String accessTokenUrl = String.format(WeChatConfig.getOpenAccessTokenUrl(),weChatConfig.getOpenAppId(),weChatConfig.getOpenAppSecret());

        return null;
    }
}
