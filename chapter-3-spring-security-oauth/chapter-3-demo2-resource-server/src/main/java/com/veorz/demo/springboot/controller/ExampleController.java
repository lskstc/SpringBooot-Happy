package com.veorz.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringBoot-Learning
 * @description: 访问页面拦截
 * @author: lsk
 * @create: 2021/07/12
 */
@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @RequestMapping("/hello")
    public String hello(){
        return "world";
    }
}
