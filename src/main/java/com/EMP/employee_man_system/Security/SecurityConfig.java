//package com.EMP.employee_man_system.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//public class SecurityConfig {
//	
//	
//	@Autowired
//	private  JwtAuthenticationFilter authenticationFilter;
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
//	{
//		httpSecurity
//		.csrf(csrf -> csrf.disable())
//		.formLogin(forms -> forms.disable())
//		.httpBasic(htt -> htt.disable())
//		.authorizeHttpRequests(auth-> auth.anyRequest().authenticated()).addFilterBefore(authenticationFilter,UsernamePasswordAuthenticationFilter.class);
//		
//		return httpSecurity.build();
//	}
//	
//	
//}
