package com.anmlmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.anmlmanagement.service.CustomUserDetailService;
import com.anmlmanagement.util.security.JwtAuthenticationEntryPoint;
import com.anmlmanagement.util.security.JwtAuthenticationFilter;

//@EnableGlobalMethodSecurity
@Configuration
@EnableWebSecurity
public class WebSecurity  {
	
	@Autowired
	private CustomUserDetailService  customUserDetailService;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
   @Autowired
   private JwtAuthenticationFilter jwtauthenticationFilter;
    
   // @Autowired
   // AuthenticationManager authenticationManage;
	
	
	  @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	  throws Exception {
	  
			http.csrf().disable().authorizeHttpRequests().antMatchers("/authenticate").permitAll()
			.antMatchers("/foods").hasRole("NORMAL")
					.anyRequest().authenticated().and().exceptionHandling()
					.authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.addFilterBefore(this.jwtauthenticationFilter, UsernamePasswordAuthenticationFilter.class);
			http.authenticationProvider(authenticationProvider());
			return http.build();
		}
	 
		
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .csrf() .disable() .authorizeHttpRequests()
	 * .antMatchers("/authenticate").permitAll() .antMatchers("/dogs").permitAll()
	 * .anyRequest() .authenticated() .and()
	 * .exceptionHandling().authenticationEntryPoint(this.
	 * jwtAuthenticationEntryPoint) .and() .sessionManagement()
	 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 * http.addFilterBefore(this.authenticationFilter,
	 * UsernamePasswordAuthenticationFilter.class);
	 * http.authenticationProvider(authenticationProvider()); }
	 */
		 	 
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.userDetailsService(customUserDetailService).passwordEncoder(
	 * passwordEncoder()); }
	 */
    @Bean	 	
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

	/*
	 * @Bean
	 * 
	 * @Override protected AuthenticationManager authenticationManager() throws
	 * Exception { // TODO Auto-generated method stub return
	 * super.authenticationManager(); }
	 */

}
