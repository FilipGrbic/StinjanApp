package com.panonit.StinjanApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panonit.StinjanApp.models.User;
import com.panonit.StinjanApp.repositories.UserRepository;

@Service("userService")
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User findUserByUsername(String username) {
		User user = userRepository.findUserByUsername(username);
		return user;
	}
	
	public List<User> allUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getById(Integer userId){
		return userRepository.findById(userId);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user, Integer userId) {
		user.setUserId(userId);
		return userRepository.save(user);
	}
	
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}
}
