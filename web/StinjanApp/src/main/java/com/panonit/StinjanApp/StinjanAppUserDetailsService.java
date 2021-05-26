package com.panonit.StinjanApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.panonit.StinjanApp.services.UserService;

@Service
public class StinjanAppUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserService userService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.panonit.StinjanApp.models.User user = userService.findUserByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found by username: " + username);
		} else {
			UserDetails userDetails = toUserDetails(user);
			return userDetails;
		}
	}
	
	private UserDetails toUserDetails(com.panonit.StinjanApp.models.User user) {
		return User.withUsername(user.getUsername()).password(bCryptPasswordEncoder.encode(user.getPassword()))
				.roles(user.getRole().getName())
				.build();
	}
}
