package com.example.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.domain.AuthenticationRequestDto;
import com.example.domain.LoginResponse;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.security.jwt.JwtTokenProvider;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findUserById(id);
	}

	@Override
	public List<User> findUserByMoreAge(int age) {

		return userRepository.findUserByMoreAge(age);
	}

	@Override
	public List<User> findUniqueNameMoreThree() {

		return userRepository.findUniqueNameMoreThree();
	}

	@Override
	public User findUserByEmail(String email) {

		return userRepository.findUserByEmail(email);
	}

	@Override
	public User register(User user) {

		Role roleUser = roleRepository.findByRole("ROLE_USER");
		List<Role> userRoles = new ArrayList<>();
		userRoles.add(roleUser);

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(userRoles);

		User registeredUser = userRepository.save(user);

		return registeredUser;
	}

	@Override
	public ResponseEntity<?> login(AuthenticationRequestDto requestDto) {

		try {

			User user = userRepository.findUserByEmail(requestDto.getEmail());
			if (user == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
			}

			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword()));
			String token = jwtTokenProvider.createToken(requestDto.getEmail(), user.getRoles());

			LoginResponse loginResponse = new LoginResponse(requestDto.getEmail(), token);

			Map<Object, Object> response = new HashMap<>();
			response.put("email", requestDto.getEmail());
			response.put("token", token);

			return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid email or password");
		}

	}

}
