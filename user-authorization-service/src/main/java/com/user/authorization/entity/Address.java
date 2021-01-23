package com.user.authorization.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address extends EntityMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private long id;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "ADDRESS1")
	private String address1;

	@Column(name = "ADDRESS2")
	private String address2;

	@Column(name = "ZIPCODE")
	private String zipcode;

	@Column(name = "COUNTRY")
	private String nationality;

	@Column(name = "USER_ID")
	private long userId;

	public Address() {

	}


	public long getId() { return id; }


	public void setId(long id) { this.id = id; }


	public String getCity() { return city; }


	public void setCity(String city) { this.city = city; }


	public String getState() { return state; }


	public void setState(String state) { this.state = state; }


	public String getAddress1() { return address1; }


	public void setAddress1(String address1) { this.address1 = address1; }


	public String getAddress2() { return address2; }


	public void setAddress2(String address2) { this.address2 = address2; }


	public String getZipcode() { return zipcode; }


	public void setZipcode(String zipcode) { this.zipcode = zipcode; }


	public String getNationality() { return nationality; }


	public void setNationality(String nationality) {

		this.nationality = nationality;
	}


	public long getUserId() { return userId; }


	public void setUserId(long userId) { this.userId = userId; }

}
