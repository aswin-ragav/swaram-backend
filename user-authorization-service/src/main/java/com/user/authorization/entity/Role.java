package com.user.authorization.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Role {

	@Column(name = "ROLE_TYPE")
	private String roleType;

	public Role() {
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

}
