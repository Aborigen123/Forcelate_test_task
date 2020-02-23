package com.example.domain;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = 9188746235778119480L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Response(String message) {
		super();
		this.message = message;
	}

}
