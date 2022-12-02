package com.anmlmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anmlmanagement.service.CustomUserDetailService;
import com.anmlmanagement.util.security.JwtAuthRequest;
import com.anmlmanagement.util.security.JwtAuthResponse;
import com.anmlmanagement.util.security.JwtTokenHelper;

@RestController
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Autowired
	private DaoAuthenticationProvider authenticationProvider;
	
	@PostMapping("/authenticate")
	public ResponseEntity<JwtAuthResponse> createToken(
			@RequestBody JwtAuthRequest request) {
		
		try {
		
			authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			
			/*
			 * this.authenticate(request.getUsername(), request.getPassword()); UserDetails
			 * userDetails =
			 * this.userDetailsService.loadUserByUsername(request.getUsername()); //
			 * System.out.println(userDetails); String token =
			 * this.jwtTokenHelper.generateToken(userDetails); JwtAuthResponse response =
			 * new JwtAuthResponse(); response.setToken(token);
			 */
		} catch(Exception exception) {
			System.out.println("Error found while authenticating");
		}
		final UserDetails userDetails= customUserDetailService.loadUserByUsername(request.getUsername());
		final String jwt = jwtTokenHelper.generateToken(userDetails);
		System.out.println(jwt);
		return ResponseEntity.ok(new JwtAuthResponse(jwt));
		
	}

//	private void authenticate(String username, String password) {
//		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
//		try {
//			this.authenticationProvider.authenticate(authenticationToken);
//		}catch(DisabledException exception) {
//			
//		}	
//	}
}
