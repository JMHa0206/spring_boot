package com.kedu.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kedu.study.security.JwtFilter;

@Configuration
public class SecurityConfig {
	  @Autowired
	    private JwtFilter jwtFilter;

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeHttpRequests()
	            .requestMatchers("/work/**").authenticated() // 필요한 경우 경로 조정
	            .anyRequest().permitAll()
	            .and()
	            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // ✅ 필터 등록

	        return http.build();
	    }
}
