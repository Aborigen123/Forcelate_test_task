package com.example.domain;

import com.example.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDtoForJWT {
	private Long id;
	private String username;
	private String email;

	public User toUser() {
		User user = new User();
		user.setId(id);
		user.setName(username);
		user.setEmail(email);

		return user;
	}

	public static UserDtoForJWT fromUser(User user) {
		UserDtoForJWT userDto = new UserDtoForJWT();
		userDto.setId(user.getId());
		userDto.setUsername(user.getName());
		userDto.setEmail(user.getEmail());

		return userDto;
	}

	public UserDtoForJWT(Long id, String username, String firstName, String lastName, String email) {
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public UserDtoForJWT() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
