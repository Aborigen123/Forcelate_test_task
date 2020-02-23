package com.example.domain;

import javax.validation.constraints.NotEmpty;

import com.example.annotation.annotation.UniqueEmail;
import com.example.entity.Role;

public class UserRegistrationRequest {
	@NotEmpty(message = "can't be empty")
	private String name;
	private int age;
	@UniqueEmail
	@NotEmpty(message = "can't be empty")
	private String email;
	@NotEmpty(message = "can't be empty")
	private String password;
	private Role role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRegistrationRequest(@NotEmpty(message = "can't be empty") String name,
			@NotEmpty(message = "can't be empty") int age, @NotEmpty(message = "can't be empty") String email,
			@NotEmpty(message = "can't be empty") String password, Role role) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.password = password;
		this.role = role;
	}

	public UserRegistrationRequest() {
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
