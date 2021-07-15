package com.veorz.demo.springboot.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringBoot-Learning
 * @description: 开启SSO功能
 * @author: lsk
 * @create: 2021/07/15
 */
@Configuration
@EnableOAuth2Sso
public class OAuthSsoConfig {
}
