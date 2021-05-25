package org.sid.revisionmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {

	//use one user with a password generated in the starter of the project
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = passwordEncoder();
		
		System.out.println("********************");
		System.out.println(passwordEncoder.encode("1234"));
		System.out.println("********************");
		
		//without encrypting the password{noop}
		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("USER");
		auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1234")).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("USER","ADMIN");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		//http.httpBasic();
		//if we want access over this kind of sites we need to be an admin
		http.authorizeRequests().antMatchers("/save**/**","/delete**/**","/form**/**").hasRole("ADMIN");
		//we always need authentification
		http.authorizeRequests().anyRequest().authenticated();
		http.csrf();
		http.exceptionHandling().accessDeniedPage("/notAutorized");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
