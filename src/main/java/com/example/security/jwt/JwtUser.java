package com.example.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUser implements UserDetails {

	private static final long serialVersionUID = 7094797118275264079L;

	private final Long id;
	private final String name;
	private final int age;
	private final String password;
	private final String email;
	private final boolean enabled;
	private final Collection<? extends GrantedAuthority> authorities;

	public JwtUser(Long id, String name, int age, String password, String email, boolean enabled,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public String getEmail() {
		return email;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
