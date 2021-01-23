package com.user.authorization.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact extends EntityMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACT_ID")
	private long id;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "ALTERNATE_EMAIL")
	private String alternateEmail;

	@Column(name = "ALTERNATE_PHONE_NUMBER")
	private String alternatePhoneNumber;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "USER_ID")
	private long userId;

	public Contact() {

	}


	public long getId() { return id; }


	public void setId(long id) { this.id = id; }


	public String getPhoneNumber() { return phoneNumber; }


	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}


	public String getAlternateEmail() { return alternateEmail; }


	public void setAlternateEmail(String alternateEmail) {

		this.alternateEmail = alternateEmail;
	}


	public String getAlternatePhoneNumber() { return alternatePhoneNumber; }


	public void setAlternatePhoneNumber(String alternatePhoneNumber) {

		this.alternatePhoneNumber = alternatePhoneNumber;
	}


	public Date getDob() { return dob; }


	public void setDob(Date dob) { this.dob = dob; }


	public long getUserId() { return userId; }


	public void setUserId(long userId) { this.userId = userId; }

}
