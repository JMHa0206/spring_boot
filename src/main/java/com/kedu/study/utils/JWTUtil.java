package com.kedu.study.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;

@Component
public class JWTUtil {
	
	private String secret = "wewillwinthecrownagainstthisabstacle";
	
	public boolean validataion(String token) {
		try {
		Algorithm algorithm = Algorithm.HMAC256(secret);
		JWTVerifier verifier = JWT.require(algorithm).build();
		verifier.verify(token);
		return true;
	}catch(Exception e) {
		return false;
	}
}
	public String createToken(String loginID, int per_secure, String per_function) {
		
		Algorithm algorithm = Algorithm.HMAC256(secret);
		Date now = new Date();
		Date expiresAt = new Date(now.getTime()+86400000);
		return JWT.create().withSubject(loginID)
				.withClaim("per_secure", per_secure)
				.withClaim("per_function", per_function)
				.withIssuedAt(now)
				.withExpiresAt(expiresAt)
				.sign(algorithm);
	 }

	}

