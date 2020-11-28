package com.user.authorization.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VerificationStatus {

	@Column(name = "VERIFICATION_STATUS")
	private String verificationStatus;

	public VerificationStatus() {
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

}
