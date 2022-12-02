package com.anmlmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anmlmanagement.dao.UserDao;
import com.anmlmanagement.model.CustomUserDetails;
import com.anmlmanagement.model.User;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		User user = userDao.findByUsername(userName);

		if(null ==  user) {
			throw new UsernameNotFoundException("User not found exception");
		} else {
			return new CustomUserDetails(user);
		}
	}

}
