package com.panonit.StinjanApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panonit.StinjanApp.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Integer>{
	User findUserByUsername(String username);
}
