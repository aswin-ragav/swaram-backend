package com.user.authorization.Interface;

import org.springframework.stereotype.Service;

import com.user.authorization.entity.Authorization;

@Service
public interface AuthorizationCommon {

	Authorization logIn(String uNameOrEmail, String password);
	boolean signOff(String uNameOrEmail);

}
