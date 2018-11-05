package com.perye.example.config;

import com.perye.example.security.CustomUserService;
import com.perye.example.utils.MD5Util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: Perye
 * @create: 2018-10-23 21:33
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注册UserDetailsService的bean
     * @return
     */
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // userDetailsService验证
        auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.encode((String) charSequence);
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(MD5Util.encode((String) charSequence));
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //任何请求，登陆后可以访问
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .failureUrl("/login?error")
                //登录页面用户任意访问
                .permitAll()
                .and()
                .logout()
                //注销行为任意访问
                .permitAll();

    }
}
