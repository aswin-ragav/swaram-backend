package com.user.authorization.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long				id;

	@Column(name = "FIRST_NAME")
	private String				firstName;

	@Column(name = "LAST_NAME")
	private String				lastName;

	@Column(name = "MIDDLE_NAME")
	private String				middleName;

	@Transient
	private String				userName;

	@Embedded
	private Privacy				privacy;

	@Embedded
	private Role				role;

	@Embedded
	private VerificationStatus	verificationStatus;

	@JoinTable(	name = "USERS_ADDRESS",
				joinColumns = @JoinColumn(name = "USER_ID"),
				inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
	@ManyToMany
//	(cascade=CascadeType.ALL)
	private Collection<Address>	address	= new ArrayList<>();

	@JoinTable(	name = "USERS_CONTACT",
				joinColumns = @JoinColumn(name = "USER_ID"),
				inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
	@ManyToMany
//	(cascade=CascadeType.ALL)
	private Collection<Contact>	contact	= new ArrayList<>();

	public User() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUserName() {
		return firstName + " " + middleName + " " + lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<Address> getAddress() {
		return address;
	}

	public void setAddress(Collection<Address> address) {
		this.address = address;
	}

	public Collection<Contact> getContact() {
		return contact;
	}

	public void setContact(Collection<Contact> contact) {
		this.contact = contact;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public VerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(VerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

}
