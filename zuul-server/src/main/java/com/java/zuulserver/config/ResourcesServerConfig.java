package com.java.zuulserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import javax.annotation.Resource;

@Configuration
public class ResourcesServerConfig {

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("test-secret");
        return converter;
    }

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    //针对WEB
    @Configuration
    @EnableResourceServer
    public class AuthConfig extends ResourceServerConfigurerAdapter {
        @Autowired
        private TokenStore jwtTokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId("resl")
                    .tokenStore(jwtTokenStore)
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/**").permitAll();
        }
    }

    //针对微服务
    @Configuration
    @EnableResourceServer
    public class Resources1Config extends ResourceServerConfigurerAdapter {
        @Resource
        JwtTokenStore jwtTokenStore;
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId("resl")
                    .tokenStore(jwtTokenStore)
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/first-test/**").access("#oauth2.hasScope('all')")
                    .antMatchers("/second-test/**").access("#oauth2.hasScope('all')")
                    .antMatchers("/third-test/**").access("#oauth2.hasScope('all')")
                    .antMatchers("/front-end-system/**").access("#oauth2.hasScope('all')")
                    .and().csrf().disable();
        }
    }
}

