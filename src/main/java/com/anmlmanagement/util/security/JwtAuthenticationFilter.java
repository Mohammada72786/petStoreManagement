package com.anmlmanagement.util.security;

import java.io.IOException;
import java.nio.charset.MalformedInputException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailService;
	

	@Autowired
	JwtTokenHelper jwtTokenHelper;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestToken = request.getHeader("Authorization");
		System.out.println(requestToken);
		String username = null;
		String token = null;
		if(null != requestToken && requestToken.startsWith("Bearer")) {
			try {
				token = requestToken.substring(7);
			    username = jwtTokenHelper.getUsernameFromToken(token);
				
			}catch(IllegalArgumentException exception) {
				
			}catch(ExpiredJwtException exception) {
				
			}catch(MalformedJwtException exception) {
				
			} 
		}else {
			System.out.println("Token not starts with bearer");
		}
		if(null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
			UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
			if(this.jwtTokenHelper.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(null);
			}else {
				System.out.println("invalid token");
			}
				 
		}else {
				System.out.println("username is null pr context is not null");
		}
		filterChain.doFilter(request, response);
	}
}
