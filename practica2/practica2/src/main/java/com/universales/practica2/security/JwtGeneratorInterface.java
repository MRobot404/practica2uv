package com.universales.practica2.security;

import java.util.Map;

import com.universales.practica2.dto.Person;

public interface JwtGeneratorInterface {
	Map<String, String> generateToken(Person person);
}
