package com.veorz.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringBoot-Learning
 * @description: Spring Boot Hello World RESTful 接口
 * @author: lsk
 * @create: 2021/06/24
 */
@RestController //@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
public class RestHelloController {

    @RequestMapping(value = "/restful/hello",method = RequestMethod.GET)
    public String restfulHello(){
        return "Hello,RESTful Spring Boot!";
    }
}
