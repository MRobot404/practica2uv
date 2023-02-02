package com.universales.practica2.security;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Jwts;

import com.universales.practica2.dto.Person;

@Service
public class JwtGeneratorImpl implements JwtGeneratorInterface {

	private final String secret = "secret";
	private final String message = "Token generado exitosamente";
	private final long tokenValidityInSeconds = 60;

	@Override
	public Map<String, String> generateToken(Person person) {
		String jwtToken = "";
		Date now = new Date();
		Date expiration = new Date(now.getTime() + tokenValidityInSeconds * 1000);
		jwtToken = Jwts.builder().setSubject(person.getUsername()).setIssuedAt(now).setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
		Map<String, String> jwtTokenGen = new HashMap<>();
		jwtTokenGen.put("token", jwtToken);
		jwtTokenGen.put("message", message);	
		return jwtTokenGen;
	}

}
