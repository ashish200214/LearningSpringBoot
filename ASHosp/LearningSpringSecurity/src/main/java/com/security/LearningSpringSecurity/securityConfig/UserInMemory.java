package com.security.LearningSpringSecurity.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.security.LearningSpringSecurity.MyUserDetailsService;

@Configuration
public class UserInMemory{
	@Autowired
	private MyUserDetailsService service;

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetails() {
		
		return this.service;
	}
	@Bean
	public AuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(service);
		provider.setPasswordEncoder(encoder());
		return provider;
	}
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity security) throws Exception {
		
		return security.csrf(csrf->csrf.disable()).authorizeHttpRequests(request -> request.
			
				requestMatchers("/home","register/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasRole("USER")
				.anyRequest().authenticated()
				
				).formLogin(form -> form.permitAll()).build();
	}
}