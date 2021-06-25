package com.veorz.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: SpringBoot-Learning
 * @description: Spring Boot Hello World 普通接口
 * @author: lsk
 * @create: 2021/06/24
 */
@Controller //此注释表示这是一个普通的接口
public class NormalHelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody   //此注释显示页面内容
    public String hello(){
        return "Hello,Spring Boot!";
    }

    @RequestMapping(value = "/view/hello",method = RequestMethod.GET)
    public String viewHello(){
        //在没有配置模板引擎的时候默认跳转到 rescources/static 目录下的 helloview.html，需要在application.yaml中配置spring.mvc.view.prefix=/和spring.mvc.view.suffix=.html
        return "helloview";
    }
}
