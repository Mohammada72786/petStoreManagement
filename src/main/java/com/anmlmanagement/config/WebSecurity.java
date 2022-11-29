package com.anmlmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.anmlmanagement.service.CustomUserDetailService;
//@EnableGlobalMethodSecurity
//extends WebSecurityConfigurerAdapter
@Configuration
@EnableWebSecurity
public class WebSecurity {
	
	@Autowired
	CustomUserDetailService  customUserDetailService;

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and()
				.authorizeRequests()
				.antMatchers("/home", "/index", "/dogs", "/login").hasRole("NORMAL")
				.antMatchers("/dog", "/login").hasRole("ADMIN")
				.antMatchers("/signin").permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginProcessingUrl("/doLogin")
				.defaultSuccessUrl("/dogs");
		// loginPage("signin"); //.httpBasic();
		return http.build();

	  }
	 
		/*
		 * @Override protected void configure(HttpSecurity http) throws Exception { http
		 * .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		 * .and() .authorizeRequests()
		 * .antMatchers("/home","/index","/dogs","/login").hasRole("NORMAL")
		 * .antMatchers("/dog","/login","/dogs").hasRole("ADMIN")
		 * .antMatchers("/signin").permitAll() .anyRequest() .authenticated() .and()
		 * .formLogin() .loginProcessingUrl("/doLogin") .defaultSuccessUrl("/dogs");
		 * //loginPage("signin"); //.httpBasic(); }
		 */
    
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//	   // auth.inMemoryAuthentication().withUser("Abid").password(this.passwordEncoder().encode("Mohammad")).roles("NORMAL");
//	   // auth.inMemoryAuthentication().withUser("Mohammad").password(this.passwordEncoder().encode("Abid")).roles("ADMIN");
//		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
//	
//	}
	
	protected DaoAuthenticationProvider authenticationProvider() throws Exception{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.customUserDetailService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean 
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	

}
