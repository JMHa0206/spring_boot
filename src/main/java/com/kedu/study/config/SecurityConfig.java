package com.kedu.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
	        return http
	            .csrf(csrf -> csrf.disable()) // ✅ 람다 방식으로 비활성화
	            .authorizeHttpRequests(auth -> auth
	            	.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	                .requestMatchers("/work/**").authenticated()
	                .anyRequest().permitAll()
	            )
	            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
	            .build(); // ✅ .build() 호출로 마무리
	    }
}
