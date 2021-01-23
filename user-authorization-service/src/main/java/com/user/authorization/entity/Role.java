package com.user.authorization.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Role extends EntityMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "ROLE_TYPE")
	private String roleType;

	public Role() {

	}


	public long getUserId() { return userId; }


	public void setUserId(long userId) { this.userId = userId; }


	public String getRoleType() { return roleType; }


	public void setRoleType(String roleType) { this.roleType = roleType; }

}
