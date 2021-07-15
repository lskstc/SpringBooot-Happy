package com.veorz.demo.springboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringBoot-Learning
 * @description: 获取当前用户的/user/info接口
 * @author: lsk
 * @create: 2021/07/15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info")
    public Authentication info(Authentication authentication){
        return authentication;
    }
}
