package com.example.mapper;

import com.example.domain.UserRegistrationRequest;
import com.example.entity.User;

public interface UserRegisterMapper {

	public static User registerToUser(UserRegistrationRequest userRegistrationRequest) {
		User user = new User();

		user.setEmail(userRegistrationRequest.getEmail());
		user.setPassword(userRegistrationRequest.getPassword());
		user.setName(userRegistrationRequest.getName());
		user.setAge(userRegistrationRequest.getAge());

		return user;
	}
 
}