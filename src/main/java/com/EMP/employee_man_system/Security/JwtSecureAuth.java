//package com.EMP.employee_man_system.Security;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//
//import javax.crypto.SecretKey;
//
//import org.springframework.stereotype.Service;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//
//@Service
//public class JwtSecureAuth {
//	
//	private final String SECRET_KEY = "my_secretKey_mysecretKey_my_secretKey@123";
//	
//	private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
//	
//	public String extractEmail(String token)
//	{
//		return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
//	}
//	
//	
//	public boolean isTokenValid(String token)
//	{
//		try
//		{
//			Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
//			return true;
//		}
//		catch (Exception e) {
//			return false;
//		}
//	}
//}
