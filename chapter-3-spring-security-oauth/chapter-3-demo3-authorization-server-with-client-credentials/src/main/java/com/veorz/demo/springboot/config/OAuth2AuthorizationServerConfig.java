package com.veorz.demo.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

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

    /**
     * 用户详情 Service
     */
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
        endpoints.authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception{
        oauthServer.checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.inMemory() // <4.1>
                .withClient("clientapp").secret("112233") // <4.2> Client 账号、密码。
                .authorizedGrantTypes("password","refresh_token") // <4.2> 密码模式,带刷新token
                .scopes("read_userinfo","read_contacts") // <4.2> 可授权的 Scope
                .accessTokenValiditySeconds(3600) // 访问令牌的有效期为 3600 秒 = 1 小时
                .refreshTokenValiditySeconds(864000) // 刷新令牌的有效期为 864000 秒 = 10 天
                //.and().withClient() // <4.3> 可以继续配置新的 Client
                ;
    }
}
