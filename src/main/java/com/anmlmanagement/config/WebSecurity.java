package com.anmlmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.anmlmanagement.service.CustomUserDetailService;
import com.anmlmanagement.util.security.JwtAuthenticationEntryPoint;
import com.anmlmanagement.util.security.JwtAuthenticationFilter;
//@EnableGlobalMethodSecurity
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailService  customUserDetailService;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
   @Autowired
   private JwtAuthenticationFilter authenticationFilter;
    
   // @Autowired
   // AuthenticationManager authenticationManage;
	
/**	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		*
		 * http
		 * .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		 * .and() .authorizeRequests() .antMatchers("/home", "/index", "/dogs",
		 * "/login").hasRole("NORMAL") .antMatchers("/dog", "/login").hasRole("ADMIN")
		 * .antMatchers("/signin").permitAll() .anyRequest() .authenticated() .and()
		 * .formLogin() .loginProcessingUrl("/doLogin") .defaultSuccessUrl("/dogs",
		 * true) .loginPage("signin");
		 * *
		
	  }
**/
	 
		
		 @Override 
		 protected void configure(HttpSecurity http) throws Exception { 
				http
				.csrf()
				.disable()
				.authorizeHttpRequests()
				.antMatchers("/authenticate").permitAll()
				.antMatchers("/dogs").hasAnyRole("ADMIN", "NORMAL")
				.anyRequest()
				.authenticated()
				.and()
				.exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				http.addFilterBefore(this.authenticationFilter,UsernamePasswordAuthenticationFilter.class);
		  }
		 	 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}
			 	
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

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
}
