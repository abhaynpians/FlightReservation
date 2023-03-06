package com.abhay.flightreservation.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

//	 AuthenticationManager authenticationManager;

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		
//		return new BCryptPasswordEncoder();
//	}

//    @SuppressWarnings("deprecation")
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
				.requestMatchers("/WEB-INF/jsps/login/registerUser.jsp","/WEB-INF/jsps/login/login.jsp", "/showReg", "/", "/index.html", "/registerUser", "/login",
						"/showLogin", "/login/*")
				.permitAll().requestMatchers("/admin/showAddFlight/**").hasAuthority("ADMIN").anyRequest()
				.authenticated().and().csrf().disable();

		return http.build();

	}
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
//	    return builder.getOrBuild();
//	}
//	
////	
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//	    return super.authenticationManagerBean();
//	}
//	

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		final List<GlobalAuthenticationConfigurerAdapter> configurers = new ArrayList<>();
		configurers.add(new GlobalAuthenticationConfigurerAdapter() {
			@Override
			public void configure(AuthenticationManagerBuilder auth) throws Exception {
				// auth.doSomething()
			}
		});
		return authConfig.getAuthenticationManager();
	}

}
