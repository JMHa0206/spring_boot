package com.kedu.study.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kedu.study.utils.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwt;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        System.out.println("Authorization Header: " + header);

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            if (!jwt.validataion(token)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid Token");
                return;
            }

            DecodedJWT decoded = JWT.decode(token);
            String userId = decoded.getSubject();
            String role = decoded.getClaim("per_function").asString();

            System.out.println("Decoded Token - userId: " + userId + ", role: " + role);
            System.out.println("Filter passed");

            // ✅ 사용자 정보를 HttpServletRequest에 저장
            request.setAttribute("userId", userId);
            request.setAttribute("userRole", role != null ? role : "ROLE_USER");

            // ✅ Spring Security 인증 객체 설정
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userId, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            System.out.println("❌ Missing or malformed Authorization Header");
        }

        filterChain.doFilter(request, response);
    }
}
