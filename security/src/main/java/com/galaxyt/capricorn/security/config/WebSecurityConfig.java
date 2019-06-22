package com.galaxyt.capricorn.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${system.user.password.secret}")
    private String secret;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用阴钥设置密码编码器
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);

        auth.userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // 限定"/user/welcome"和"/user/details"赋予角色USER和ADMIN，hasAnyRole会默认加入ROLE_前缀
                .antMatchers("/user/welcome", "/user/details").hasAnyAuthority("USER","ADMIN")
                //限定"/admin/"下所有请求权限赋予角色ADMIN，hasAuthority不会默认加入ROLE_前缀
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                //其他路径允许签名后访问
                .anyRequest().permitAll()
                //对没有配置权限的其他请求允许匿名访问
                .and().anonymous()
                //使用Spring Security默认的登陆页面
                .and().formLogin()
                //启动HTTP基础验证
                .and().httpBasic();

    }



}
