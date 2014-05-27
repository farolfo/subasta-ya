package com.example.subastaya;

import java.io.Serializable;

public class AuthUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String token;
	String nickname;

	public AuthUser(String token, String nickname) {
		this.token = token;
		this.nickname = nickname;
	}

	public String getToken() {
		return token;
	}

	public String getNickname() {
		return nickname;
	}
	
}
