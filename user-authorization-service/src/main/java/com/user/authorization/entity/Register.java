package com.user.authorization.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER_REGISTRATION")
public class Register extends EntityMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REGISTER_ID")
	private long id;

	@Column(name = "USERNAME", unique = true)
	private String userName;

	@Column(name = "EMAIL_ADDRESS", unique = true)
	private String mailId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "STATUS")
	private String status;

	@JsonIgnore
	@Column(name = "UNIQUE_ID")
	private String uniqueId;

	@Transient
	private String cfnPassword;

	public Register() {

	}


	public long getId() { return id; }


	public void setId(long id) { this.id = id; }


	public String getUserName() { return userName; }


	public void setUserName(String userName) { this.userName = userName; }


	public String getMailId() { return mailId; }


	public void setMailId(String mailId) { this.mailId = mailId; }


	public String getPassword() { return password; }


	public void setPassword(String password) { this.password = password; }


	public String getStatus() { return status; }


	public void setStatus(String status) { this.status = status; }


	public void setUniqueId(String uniqueId) { this.uniqueId = uniqueId; }


	public String getCfnPassword() { return cfnPassword; }


	public void setCfnPassword(String cfnPassword) {

		this.cfnPassword = cfnPassword;
	}

}
