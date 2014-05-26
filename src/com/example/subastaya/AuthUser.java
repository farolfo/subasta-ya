package com.example.subastaya;

public class AuthUser {
	
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
