package com.kedu.study.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kedu.study.utils.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JWTUtil jwt;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
	                                HttpServletResponse response,
	                                FilterChain filterChain) throws ServletException, IOException {

	    String header = request.getHeader("Authorization");

	    if (header != null && header.startsWith("Bearer ")) {
	        String token = header.substring(7);

	        if (jwt.validataion(token)) {
	            DecodedJWT decoded = JWT.decode(token);
	            String userId = decoded.getSubject();
	            String role = decoded.getClaim("role").asString();

	            // 👉 여기! 인증된 사용자 정보를 Request에 저장
	            request.setAttribute("userId", userId);
	            request.setAttribute("userRole", role != null ? role : "ROLE_USER");
	        }
	    }

	    filterChain.doFilter(request, response);
	}
}
