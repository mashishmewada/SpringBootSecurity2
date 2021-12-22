package com.learn.springsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.springsecurity.models.CustomUserDetails;
import com.learn.springsecurity.models.User;
import com.learn.springsecurity.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUserName(username);
		
		if(user==null) {
			
			throw new UsernameNotFoundException("NO USER");
		}
		
		return new CustomUserDetails(user);
	}

}
