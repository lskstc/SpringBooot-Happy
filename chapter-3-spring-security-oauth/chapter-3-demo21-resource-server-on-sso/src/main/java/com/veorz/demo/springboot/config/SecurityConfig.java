package com.veorz.demo.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @program: SpringBoot-Learning
 * @description: 权限控制
 * @author: lsk
 * @create: 2021/07/15
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 开启对 Spring Security 注解的方法，进行权限验证。
@Order(101) // OAuth2SsoDefaultConfiguration 使用了 Order(100)，所以这里设置为 Order(101)，防止相同顺序导致报错
public class SecurityConfig extends WebSecurityConfigurerAdapter {
}
