package com.kedu.study.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;

@Component
public class JWTUtil {
	
	private String secret = "wewillwinthecrownagainstthisabstacle";
	
	public String createToken(String loginID, String perFunction, String perSecure) {
		
		Algorithm algorithm = Algorithm.HMAC256(secret);
		Date now = new Date();
		Date expiresAt = new Date(now.getTime()+86400000);
		return JWT.create().withSubject(loginID)
				.withClaim("per_secure", perSecure)
				.withClaim("per_function", perFunction)
				.withIssuedAt(now)
				.withExpiresAt(expiresAt)
				.sign(algorithm);
	}
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
	
}
