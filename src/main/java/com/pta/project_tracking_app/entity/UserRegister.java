package com.pta.project_tracking_app.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegister {
	@NotNull(message = "is required!")
	@Size(max = 15, message = "max 15 characters allowed!")
	private String username;

	@NotNull(message = "is required!")
	@Email(message = "invalid email!")
	private String email;

	@NotNull(message = "is required!")
	@Size(min = 5, max = 18, message = "min 5 and max 18 characters allowed!")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
