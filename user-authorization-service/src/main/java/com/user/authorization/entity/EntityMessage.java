package com.user.authorization.entity;

import javax.persistence.Transient;

public class EntityMessage {

	@Transient
	private String entityMessage;

	public EntityMessage() {

	}


	public String getEntityMessage() { return entityMessage; }


	public void setEntityMessage(String entityMessage) {

		this.entityMessage = entityMessage;
	}

}
