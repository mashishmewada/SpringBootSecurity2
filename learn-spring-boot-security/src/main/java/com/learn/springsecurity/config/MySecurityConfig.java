package com.learn.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.learn.springsecurity.models.CustomUserDetails;
import com.learn.springsecurity.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
				.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and()
				.authorizeRequests()
				.antMatchers("/signin").permitAll()
				.antMatchers("/public/**").hasRole("NORMAL")
				.antMatchers("/users/**").hasRole("ADMIN")
				.anyRequest()
				.authenticated()
				.and()
				//.httpBasic();
				.formLogin()
				.loginPage("/signin")
				.loginProcessingUrl("/doLogin")
				.defaultSuccessUrl("/users/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.inMemoryAuthentication().withUser("ashish").password(this.bCryptPasswordEncoder().encode("ashish")).roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("deepa").password(this.bCryptPasswordEncoder().encode("deepa")).roles("ADMIN");
	
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	//ROLE - hugh level Overview -> Normal : READ
	//Authority - permission -> READ
	//ADMIN - READ, WRITE, UPDATE
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	

}
