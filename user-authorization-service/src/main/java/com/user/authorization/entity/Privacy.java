package com.user.authorization.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Privacy {

	@Column(name = "PASSWORD")
	private String	password;

	@Column(name = "CONFIRM_PASSWORD")
	private String	confirmPassword;

	@Column(name = "CREATED_TIME")
	private Date	timeStamp;

	public Privacy() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
