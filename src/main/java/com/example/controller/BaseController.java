package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.domain.AuthenticationRequestDto;
import com.example.domain.UserRegistrationRequest;
import com.example.entity.User;
import com.example.mapper.UserRegisterMapper;
import com.example.service.UserService;

@RestController
public class BaseController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto requestDto) {

		if (requestDto == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
		return userService.login(requestDto);
	}

	@PostMapping("/registration")
	public ResponseEntity<?> registration(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest,
			BindingResult result) {

		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email not unique");
		}

		User user = UserRegisterMapper.registerToUser(userRegistrationRequest);

		return new ResponseEntity<User>(userService.register(user), HttpStatus.CREATED);
	}

}
