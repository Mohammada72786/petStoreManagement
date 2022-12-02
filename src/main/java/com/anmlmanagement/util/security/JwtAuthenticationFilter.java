package com.anmlmanagement.util.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.anmlmanagement.service.CustomUserDetailService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Service
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	

	@Autowired
	JwtTokenHelper jwtTokenHelper;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestToken = request.getHeader("Authorization");
		
		if(requestToken != null) {
			System.out.println("I am  not null" +requestToken);
		}
		String username = null;
		String token = null;
		if(null != requestToken && requestToken.startsWith("Bearer")) {
			try {
				token = requestToken.substring(7);
				System.out.println("i am here" + token);
			    username = jwtTokenHelper.getUsernameFromToken(token);
			    System.out.println(username);
				
			}catch(IllegalArgumentException exception) {
				
			}catch(ExpiredJwtException exception) {
				
			}catch(MalformedJwtException exception) {
				
			} 
		}else {
			System.out.println("Token not starts with bearer");
		}
		if(null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
			UserDetails userDetails = this.customUserDetailService.loadUserByUsername(username);
			if(this.jwtTokenHelper.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				System.out.println("invalid token");
			}
				 
		}else {
				System.out.println("username is null pr context is not null");
		}
		filterChain.doFilter(request, response);
	}
}
