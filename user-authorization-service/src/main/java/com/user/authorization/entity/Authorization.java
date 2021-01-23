package com.user.authorization.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_AUTHORIZATION")
public class Authorization extends EntityMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID")
	private long id;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "EMAIL_ADDRESS")
	private String mailId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "IS_LOGGED")
	private boolean isLogged;

	@Column(name = "LAST_LOG_TIME")
	private Date date;

	// constructor
	public Authorization() {

	}


	public long getId() { return id; }


	public void setId(long id) { this.id = id; }


	public String getUserName() { return userName; }


	public void setUserName(String userName) { this.userName = userName; }


	public String getMailId() { return mailId; }


	public void setMailId(String mailId) { this.mailId = mailId; }


	public String getPassword() { return password; }


	public void setPassword(String password) { this.password = password; }


	public boolean isLogged() { return isLogged; }


	public void setLogged(boolean isLogged) { this.isLogged = isLogged; }


	public Date getDate() { return date; }


	public void setDate(Date date) { this.date = date; }

}
