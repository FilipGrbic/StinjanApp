package com.panonit.StinjanApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panonit.StinjanApp.models.User;
import com.panonit.StinjanApp.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/list")
	public List<User> allUsers(){
		return userService.allUsers();
	}
	
	@GetMapping("/getById/{userId}")
	public Optional<User> getById(@PathVariable(value = "userId") Integer userId){
		return userService.getById(userId);
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		User us = userService.saveUser(user);
		return us;
	}
	
	@PutMapping("/update/{userId}")
	public User updateUser(@RequestBody User user,@PathVariable(value = "userId") Integer userId) {
		User us = userService.saveUser(user);
		return userService.updateUser(us, userId);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") Integer userId){
		try {
			userService.deleteUser(userId);
		} catch(Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
