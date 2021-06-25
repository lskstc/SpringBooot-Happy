package com.veorz.demo.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @program: SpringBoot-Learning
 * @description: 通过重写 WebSecurityConfigurerAdapter 的方法，自定义的 Spring Security 的配置
 * @author: lsk
 * @create: 2021/06/24
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  //此注解不加的话，TestController中示例可以实现，DemoController中示例不行
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception{
        http
                // <X> 配置请求地址的权限
                .authorizeRequests()
                    .antMatchers("/test/demo").permitAll()  // 所有用户可访问
                    .antMatchers("/test/admin").hasRole("ADMIN") // 需要 ADMIN 角色
                    .antMatchers("/test/normal").access("hasRole('ROLE_NORMAL')") // 需要 NORMAL 角色
                    // 任何请求，访问的用户都需要经过认证
                    .anyRequest().authenticated()
                .and()
                // <Y> 设置 Form 表单登录
                .formLogin()
                //.loginPage("/login") // 设置自定义登录页面
                    .permitAll()
                .and()
                // 配置退出相关
                .logout()
                //.logoutUrl("/logout") // 设置自定义退出页面
                .permitAll(); // 所有用户可访问



    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.
                // <X> 使用内存中的 InMemoryUserDetailsManager
                inMemoryAuthentication()
                // <Y> 不使用 PasswordEncoder 密码编码器
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                // <Z> 配置 admin 用户
                .withUser("admin").password("admin").roles("ADMIN")
                // <Z> 配置 normal 用户
                .and().withUser("normal").password("normal").roles("NORMAL");
    }
}
