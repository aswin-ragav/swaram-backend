package com.user.authorization.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ACTIVITY")
public class Activity extends EntityMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "USER_ID")
	private long id;

	@Column(name = "ACTIVITY_TYPE")
	private boolean activityType;

	@Id
	@Column(name = "EVENT_TIMESTAMP")
	private Date date;

	public Activity() {

	}


	public long getId() { return id; }


	public void setId(long id) { this.id = id; }


	public boolean isActivityType() { return activityType; }


	public void setActivityType(boolean activityType) {

		this.activityType = activityType;
	}


	public Date getDate() { return date; }


	public void setDate(Date date) { this.date = date; }

}
