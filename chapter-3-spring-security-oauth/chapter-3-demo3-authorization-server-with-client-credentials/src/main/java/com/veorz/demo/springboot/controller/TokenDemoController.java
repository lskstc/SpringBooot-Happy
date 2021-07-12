package com.veorz.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringBoot-Learning
 * @description: 删除令牌功能
 * @author: lsk
 * @create: 2021/07/12
 */
@RestController
@RequestMapping("/token/demo")
public class TokenDemoController {

    @Qualifier("consumerTokenServices")
    @Autowired
    private ConsumerTokenServices tokenServices;

    @PostMapping(value = "/revoke")
    public boolean revokeToken(@RequestParam("token") String token) {
        return tokenServices.revokeToken(token);
    }

}
