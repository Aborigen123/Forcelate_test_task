package com.example.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.entity.Role;
import com.example.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

	public JwtUserFactory() {
	}

	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getName(), user.getAge(), user.getPassword(), user.getEmail(), true,
				mapToGrantedAuthorities(new ArrayList<>(user.getRoles())));
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
		return userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
}
