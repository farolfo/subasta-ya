package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class TokenAuthorization {
	
	@Expose
	String access_token;
	
	@Expose
	String token_type;
	
	@Expose
	Long expires_in;
	
	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Expose
	String scope;
	 
	 
}
