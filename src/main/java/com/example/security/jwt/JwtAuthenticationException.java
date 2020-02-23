package com.example.security.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4449153889053955061L;

	public JwtAuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}

	public JwtAuthenticationException(String msg) {
		super(msg);
	}
}
