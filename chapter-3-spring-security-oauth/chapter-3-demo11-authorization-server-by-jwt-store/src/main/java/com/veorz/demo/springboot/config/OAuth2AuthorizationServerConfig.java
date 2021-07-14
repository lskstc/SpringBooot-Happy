package com.veorz.demo.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @program: SpringBoot-Learning
 * @description: 授权服务器配置
 * @author: lsk
 * @create: 2021/06/28
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 用户认证 Manager
     */
    @Autowired
    AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("caicat_up"); // JWT 秘钥
        return converter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(jwtTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception{
        oauthServer.checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.inMemory() // <4.1>
                .withClient("clientapp").secret("112233") // <4.2> Client 账号、密码。
                .authorizedGrantTypes("password","refresh_token") // <4.2> 密码模式
                .scopes("read_userinfo","read_contacts") // <4.2> 可授权的 Scope
                //.and().withClient() // <4.3> 可以继续配置新的 Client
                ;
    }
}
