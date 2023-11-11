package com.cibertec.edu.pe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests().requestMatchers("/","/home").permitAll()
		.requestMatchers("/home/alumno/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.permitAll()
		.and()
		.logout().permitAll();
		return http.getOrBuild();
	}
	
	@Bean
	public static BCryptPasswordEncoder encriptadorPassword() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		PasswordEncoder passEncoder = encriptadorPassword();
		UserBuilder usuarios = User.builder().passwordEncoder(pass->{
			return passEncoder.encode(pass);
		});
		builder.inMemoryAuthentication()
		.withUser(usuarios.username("administrador").password("123456").roles("ADMIN","USER"))
		.withUser(usuarios.username("usuario").password("123456").roles("USER"));
	}
}
