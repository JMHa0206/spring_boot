package com.kedu.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kedu.study.security.JwtFilter;

@Configuration
public class FilterConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterRegistration() {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtFilter);
//        registrationBean.addUrlPatterns("/api/*");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1); // 낮을수록 먼저 적용됨
        return registrationBean;
    }
}
