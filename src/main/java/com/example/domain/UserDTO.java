package com.example.domain;

import java.io.Serializable;

import com.example.entity.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 3274590841396148930L;
	private User user;
	private String token;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDTO(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	}

}
