package com.pattysweetapp.payload.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String id;
	private String username;
	private String email;
	private int status;
	private  String message;
	private  int expiresin;
	private HttpStatus httpStatus;
	private List<String> roles;

	public JwtResponse(HttpStatus httpStatus,String accessToken, String id, String username, String email, int status,String message,int expiresin, List<String> roles) {
		this.httpStatus=httpStatus;
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.status=status;
		this.message=message;
		this.expiresin=expiresin;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getExpiresin() {
		return expiresin;
	}

	public void setExpiresin(int expiresin) {
		this.expiresin = expiresin;
	}

	public List<String> getRoles() {
		return roles;
	}
}
