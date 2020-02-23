package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.domain.AuthenticationRequestDto;
import com.example.entity.User;

public interface UserService {

	void saveUser(User user);

	User findUserById(Long id);

	List<User> findUserByMoreAge(int age);

	List<User> findUniqueNameMoreThree();

	User findUserByEmail(String email);

	User register(User user);
	
	ResponseEntity<?> login(AuthenticationRequestDto requestDto);
}
