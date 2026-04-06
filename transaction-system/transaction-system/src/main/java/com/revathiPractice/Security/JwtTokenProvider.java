package com.revathiPractice.Security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

	private static final String SECRET_KEY = "secretKey"; // Use a stronger key in production
	private static final long EXPIRATION_TIME = 86400000L; // 24 hours

	public String generateToken(String username) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

		return Jwts.builder().setSubject(username).setIssuedAt(now).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
	}

	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}
}
