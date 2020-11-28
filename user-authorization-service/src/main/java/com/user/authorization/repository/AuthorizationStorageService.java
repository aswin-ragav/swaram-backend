package com.user.authorization.repository;

import org.springframework.stereotype.Service;

import com.user.authorization.entity.User;

@Service
public interface AuthorizationStorageService {

	User addNewUser(User addUser);

	boolean deleteUser(long id);

	User updateUserDetails(User update);

}
