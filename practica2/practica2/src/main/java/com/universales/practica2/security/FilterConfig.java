package com.universales.practica2.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Clase de configuración de filtros de Spring Boot
 */
@Configuration
 public class FilterConfig {
	@Bean
	    public FilterRegistrationBean<JwtFilter> jwtFilter() {
	        FilterRegistrationBean<JwtFilter> filter= new FilterRegistrationBean<JwtFilter>();
	        filter.setFilter(new JwtFilter());
	        // Proporcionar puntos finales que deben restringirse
	        // Todos los puntos finales serán restringidos si no se especifican
	       filter.addUrlPatterns("/api/auth/hola");
	    return filter;
	    }
}
